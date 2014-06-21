package web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class DirtyFilter implements Filter {

	public DirtyFilter() {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		DirtyRequest dirtyrequest = new DirtyRequest(request);
		
		chain.doFilter(dirtyrequest, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

class DirtyRequest extends HttpServletRequestWrapper{
	
	
	private List<String> list = Arrays.asList("funk","shit");
	private HttpServletRequest request;

	public DirtyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		String value = this.request.getParameter(name);
		if(value == null){
			return value;
		}
		
		for(String dirty : list){
			if(value.contains(dirty)){
				value = value.replace(dirty, "****");
			}
		}
		return value;
	}	
}




