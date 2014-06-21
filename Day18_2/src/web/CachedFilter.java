package web;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CachedFilter implements Filter {
	private Map<String, byte[]> map = new HashMap<String, byte[]>();

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String uri = request.getRequestURI();
		
		byte b[] = map.get(uri);
		
		if(b!=null){
			response.getOutputStream().write(b);
			return;
		}
		
		
		BufferResponse1 myresponse = new BufferResponse1(response);
		chain.doFilter(request, myresponse);
		byte[] out = myresponse.getBuffer();
		
		map.put(uri,out);
		
		response.getOutputStream().write(out);
	
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

class BufferResponse1 extends HttpServletResponseWrapper{

	private ByteArrayOutputStream bout = new ByteArrayOutputStream();  //≤∂ªÒ ‰≥ˆµƒª∫¥Ê
	
	private PrintWriter pw;
	
	private HttpServletResponse response;
	public BufferResponse1(HttpServletResponse response) {
		super(response);
		this.response = response;
	}
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		
		return new MyServletOutputStream1(bout);
	}
	@Override
	public PrintWriter getWriter() throws IOException {
		pw = new PrintWriter(new OutputStreamWriter(bout,this.response.getCharacterEncoding()));
		return pw;
	}
	
	public byte[] getBuffer(){
		try{
			if(pw!=null){
				pw.close();
			}
			return bout.toByteArray();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class MyServletOutputStream1 extends ServletOutputStream{

	private ByteArrayOutputStream bout;
	public MyServletOutputStream1(ByteArrayOutputStream bout){  //Ω” ’ ˝æ›–¥µΩƒƒ¿Ô
		this.bout = bout;
	}
	
	@Override
	public void write(int b) throws IOException {
		bout.write(b);
	}
	
}
