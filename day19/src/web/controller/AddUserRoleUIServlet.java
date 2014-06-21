package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;
import domain.User;
import service.SecurityService;

/**
 * Servlet implementation class AddRolePrivilegeUIServlet
 */
@WebServlet("/AddRolePrivilegeUIServlet")
public class AddUserRoleUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		SecurityService service = new SecurityService();
		//get role information
		User user = service.findUser(user_id);
		//get all privileges
		List user_roles = service.getUserRole(user_id);
		
		List system_roles = service.getAllRole();
		
		request.setAttribute("user", user);
		request.setAttribute("user_roles", user_roles);
		request.setAttribute("system_roles", system_roles);
		System.out.println("user is :" + user);
		request.getRequestDispatcher("/addRolePrivilege.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
