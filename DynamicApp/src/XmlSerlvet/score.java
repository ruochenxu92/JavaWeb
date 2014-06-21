package XmlSerlvet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class score
 */
@WebServlet("/score")
public class score extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String Username = request.getParameter("username");
		String[] score = request.getParameterValues("name");
		int getScore = 0;
		if(score != null){
		  getScore = score.length;
		}
		Map<String, Integer> userScore = (Map<String, Integer>) request
				.getSession().getAttribute("userScore");
		
		if (userScore == null) {
			userScore = new HashMap<String, Integer>();
			System.out.println("the first time");
		}

		if (userScore.containsKey(Username)) {
			int curr = userScore.get(Username);
			userScore.put(Username, curr + getScore);
			response.getWriter().println("<h2>"+
					Username + "'s score: " + userScore.get(Username)+"</h2>");
		} else {
			userScore.put(Username, getScore);
			response.getWriter().println(
				"<h2>"+	Username + "'s score: " + userScore.get(Username)+"</h2>");
		}
		request.getSession().setAttribute("userScore",userScore);
	}
}
