package us.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.domain.User;
import us.exception.UserExistException;
import us.service.impl.BusinessServiceImpl;
import us.utils.WebUtils;
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
		System.out.println(b);
		//2.if proofread fail, go to form page, show the fail information
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}else{
		
		
		//3.if proofread successfully, 
		User user = new User();
		WebUtils.copyBean(form, user);
		
		user.setId(WebUtils.generateID());
		BusinessServiceImpl service = new BusinessServiceImpl();
	
		
		try {
			service.register(user);
			request.setAttribute("message", "Congratulation, you successfully register");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
		} catch (UserExistException e) {
			//request.setAttribute("message", "register user name exist");
			form.getError().put("username", "register user name exist");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
			return;
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "Server does not run now");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		}
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
