package webservlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;
import utils.WebUtils;
import domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao dao = new UserDao();
		User user = dao.find(username, password);
		
		if(user == null){
			request.setAttribute("message", "username or password is not correct!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("uesr", user);
		request.setAttribute("message", "Congratulation!");
		
		sendAutoLoginCookie(request, user, response);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
	
	private void sendAutoLoginCookie(HttpServletRequest request, User user, HttpServletResponse response){
		int logintime = Integer.parseInt(request.getParameter("logintime"));
		Cookie cookie = new Cookie("autologin", user.getUsername() + "." + WebUtils.md5(user.getPassword()));
		cookie.setMaxAge(logintime);
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
