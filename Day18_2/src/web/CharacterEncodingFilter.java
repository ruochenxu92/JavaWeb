package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class CharacterEncodingFilter implements Filter {

	public CharacterEncodingFilter() {
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
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		MyCharacterEncodingRequest requestWrapper = new MyCharacterEncodingRequest(request);
		
		chain.doFilter(requestWrapper, response);
		
		
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
class MyCharacterEncodingRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	
	public MyCharacterEncodingRequest(HttpServletRequest request){
		super(request);
		this.request = request;
	}
	
	
	@Override
	public String getParameter(String name) {
		try{
		String value = this.request.getParameter(name);
		if(value == null){
			return null;
		}
		
		if(!this.request.getMethod().equalsIgnoreCase("get")){
			return value;
		}
		
		value = new String(value.getBytes("ISO8859-1"),this.request.getCharacterEncoding());
		return value;
		
		}catch(Exception e){	
			throw new RuntimeException(e);
		}
		
	}
	
	
}