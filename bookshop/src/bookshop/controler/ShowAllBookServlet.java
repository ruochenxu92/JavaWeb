package bookshop.controler;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.domain.Book;
import bookshop.service.impl.BookService;
import bookshop.service.impl.BookServiceImpl;

/**
 * Servlet implementation class ShowAllBookServlet
 */
@WebServlet("/ShowAllBookServlet")
public class ShowAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookservice = new BookServiceImpl();
		Map<String, Book> books = bookservice.findAllBooks();
		
		request.getSession().setAttribute("books", books);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Booklist.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
