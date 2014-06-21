package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import utils.WebUtils;
import webservlet.UserDao;

public class AutoLoginFilter implements Filter {


	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		
		if(request.getSession().getAttribute("user") != null){
			chain.doFilter(arg0, arg1);
			return;
		}
		
		//1. get autologin cookie
		String value = null;
		Cookie cookies[] = request.getCookies();
		
		for(int i = 0; cookies!=null && i < cookies.length;i++){
			if(cookies[i].getName().equals("autologin")){
				value= cookies[i].getValue();
			}
		}
		
		
		//2. get cookie username and password
		if(value != null){
			String username = value.split("\\.")[0];
			String password = value.split("\\.")[1];
			
			UserDao dao = new UserDao();
			User user = (User) dao.find(username);
			
			if(password.equals(WebUtils.md5(user.getPassword()))){
				request.getSession().setAttribute("user", user);
			}
		}
		chain.doFilter(arg0, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
