package XmlSerlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("url:"+request.getRequestURL());
		System.out.println("uri:"+request.getRequestURI());//path in project. can relative path and absolute path
		
		System.out.println("querystring: "+request.getQueryString());
		System.out.println("IP:"+request.getRemoteAddr());//IP address
		//getContext 
		System.out.println(request.getContextPath());//Project folder
		System.out.println("request way: "+request.getMethod());//Get or Post
		System.out.println(request.getRequestURI().substring(request.getContextPath().length()));

	
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
