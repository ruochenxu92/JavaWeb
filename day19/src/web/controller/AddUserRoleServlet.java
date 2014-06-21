package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SecurityService;

/**
 * Servlet implementation class AddUserRoleServlet
 */
@WebServlet("/AddUserRoleServlet")
public class AddUserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try{
		String user_id = request.getParameter("user_id");
		String[] role_ids = request.getParameterValues("role_id");
		
		
		SecurityService service = new SecurityService();
		service.updateUserRole(user_id, role_ids);
		request.setAttribute("message", "successfully add roles!!!");
		}catch(Exception e){
			request.setAttribute("message", "failed to add roles!!! sorry !!!");
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
