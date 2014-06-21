package bookstore.controler;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookstore.domain.Book;
import bookstore.domain.Cart;
import bookstore.domain.CartItem;
import bookstore.domain.MyConstant;
import bookstore.service.BookServiceImpl;
import bookstore.service.impl.BookService;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookservice = new BookServiceImpl();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		//Check whether we have a Cart
		HttpSession session = request.getSession();
		Cart cart = (Cart) request.getSession().getAttribute(MyConstant.SHOPPING_CART);
		
		//if not create a new Cart
		Book book = bookservice.findBookById(bookid);
		if(cart == null){
			cart = new Cart();
			cart.addBook(book);
			session.setAttribute(MyConstant.SHOPPING_CART, cart);
		}else{
		//put the item on the Cart
		cart.addBook(book);
		//store the data
		}		
		//forward the  listCart
//		Cart c = (Cart) request.getSession().getAttribute("Cart");
//		Map<String, CartItem> map = c.getMap();
//		System.out.println(map.get(bookid).getPrice());
//		System.out.println(map.get(bookid).getBook().getName());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/listCart.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
