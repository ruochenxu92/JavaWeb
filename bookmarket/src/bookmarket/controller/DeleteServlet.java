package bookmarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmarket.domain.Cart;
import bookmarket.exception.CartNotFoundException;
import bookmarket.service.bookservice;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		bookservice service = new bookservice();
		
			try {
				service.delete(bookid, cart);
				
			} catch (CartNotFoundException e) {
				request.setAttribute("message", "You have not bought any item");
				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
			}
		
			request.getRequestDispatcher("/WEB-INF/cartlist.jsp").forward(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
