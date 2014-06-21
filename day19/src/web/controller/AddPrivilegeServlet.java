package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SecurityService;
import utils.WebUtils;
import domain.Privilege;

/**
 * Servlet implementation class AddPrivilegeServlet
 */
@WebServlet("/AddPrivilegeServlet")
public class AddPrivilegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		Privilege p = new Privilege();
		p.setId(WebUtils.makeUUID());
		p.setName(name);
		p.setDescription(description);
		
		SecurityService service = new SecurityService();
		service.addPrivilege(p);
		request.setAttribute("message", "Successfully add Privilege!");
		
		}catch(Exception e){
			request.setAttribute("message", "You failed to add Privilege!");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
