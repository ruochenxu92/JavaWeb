package XmlServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class letterCount
 */
@WebServlet("/letterCount")
public class letterCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("running letterCount...");
		String content = request.getParameter("letters");
		content = content.toUpperCase();
		System.out.println(content);
		int[] times = new int[26];
		for(int i = 0; i < content.length();i++){
			char c = content.charAt(i);
			if(Character.isLetter(c)){
				times[c-'A'] = times[c-'A'] + 1;
			}
		}
		
		ServletContext context = getServletContext();
		context.setAttribute("times", times);
		//forward
		RequestDispatcher dispatcher = context.getRequestDispatcher("/result");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	

}
