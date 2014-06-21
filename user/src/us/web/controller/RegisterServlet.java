package us.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.BusinessServiceImpl.BusinessServiceImpl;
import us.Util.WebUtils;
import us.domain.User;
import us.exception.UserExistException;
import us.web.formbean.RegisterForm;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		if(!b){//go back to register.jsp
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);	
			return;
		}
		
		User user = new User();
		WebUtils.copyBean(form,user);
		BusinessServiceImpl service = new BusinessServiceImpl();

		user.setBirthday(new Date());
		user.setEmail("xxx@gmail.com");
		user.setNickname("sss");
		user.setPassword("sss");
		user.setUsername("Ichangehere");
		
		
		try {
			service.register(user);
			request.setAttribute("message", "Congratulation, you have already register! <meta http-equiv='refresh' content='3;url=/user/index.jsp'>");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
		} catch (UserExistException e) {
			form.getError().put("username", "Username Exists!!!");
			System.out.println("username existsssssss!!!!");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);;
		}catch(Exception e){
			request.setAttribute("message", "Sorry, server stop running !!!");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
