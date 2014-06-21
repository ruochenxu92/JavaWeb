package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SecurityService;

/**
 * Servlet implementation class AddRolePrivilegesServlet
 */
@WebServlet("/AddRolePrivilegesServlet")
public class AddRolePrivilegesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		try {
			String role_id = request.getParameter("role_id");
			System.out.println("role_id:"+role_id);
			String[] privilege_id = request.getParameterValues("privilege_id");

			SecurityService service = new SecurityService();
			service.updateRolePrivilege(role_id, privilege_id);
			request.setAttribute("message", "Add Privileges successfully");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Add Privileges Failed");
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
