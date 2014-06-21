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
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		bookservice service = new bookservice();
		System.out.println(cart);
		System.out.println(service);
		try {
			service.updateCart(bookid, quantity, cart);
			request.getRequestDispatcher("/WEB-INF/cartlist.jsp").forward(request, response);

		} catch (CartNotFoundException e) {
			request.setAttribute("message", "You have not bought any item");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		}
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
