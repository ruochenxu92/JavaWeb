package bookshop.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.domain.Book;
import bookshop.domain.Cart;
import bookshop.service.impl.BookService;
import bookshop.service.impl.BookServiceImpl;

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
		//System.out.println(bookid);
		Book book = bookservice.getBookById(bookid);
		//System.out.println(book.getName());
	    Cart cart = (Cart) request.getSession().getAttribute("cart");
	    if(cart == null){
	    	cart = new Cart();
	    	cart.addBook(book);
	    	request.getSession().setAttribute("cart", cart);
	    }else{
	    	cart.addBook(book);
	    	request.getSession().setAttribute("cart", cart);
	    }
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/Cartlist.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
