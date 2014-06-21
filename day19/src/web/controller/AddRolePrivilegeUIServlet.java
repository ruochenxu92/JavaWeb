package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;
import service.SecurityService;

/**
 * Servlet implementation class AddRolePrivilegeUIServlet
 */
@WebServlet("/AddRolePrivilegeUIServlet")
public class AddRolePrivilegeUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role_id = request.getParameter("role_id");
		SecurityService service = new SecurityService();
		//get role information
		Role role = service.findRole(role_id);
		//get all privileges
		List role_privileges = service.getRolePrivilege(role_id);
		List system_privileges = service.getAllPrivilege();
		
		request.setAttribute("role", role);
		request.setAttribute("role_privileges", role_privileges);
		request.setAttribute("system_privileges", system_privileges);
		System.out.println("role is:" + role);
		request.getRequestDispatcher("/addRolePrivilege.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
