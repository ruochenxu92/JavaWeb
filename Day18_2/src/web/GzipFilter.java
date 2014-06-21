package web;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

public class GzipFilter implements Filter {

	public GzipFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		BufferResponse myresponse = new BufferResponse(response);
		
		chain.doFilter(request, myresponse);
		
		byte[] out = myresponse.getBuffer();
		System.out.println("Original size: " + out.length);
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(out);
		gout.close();
		
		byte[] gzip = bout.toByteArray();
		
		System.out.println("Compressed Size:" +gzip.length);
		
		response.setHeader("content-encoding", "gzip");
		
		
		
		
		
		

		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
