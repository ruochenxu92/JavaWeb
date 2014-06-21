package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//control cache filter
public class Expires implements Filter {
	
	private FilterConfig filterConfig = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {	
		HttpServletRequest request =(HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		//1. get user object resources
		String uri = request.getRequestURI();
		//2. get user want to visit 
		String ext = uri.substring(uri.lastIndexOf(".")+1);
		String time = filterConfig.getInitParameter(ext);
		if(time != null){
			long t = Long.parseLong(time) * 3600 * 1000;
			response.setDateHeader("Expires", System.currentTimeMillis() + t);
		}
		chain.doFilter(arg0, arg1);
	
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
	}

}
