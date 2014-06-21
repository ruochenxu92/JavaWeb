package bookstore.controler;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.domain.Book;
import bookstore.service.BookServiceImpl;

/**
 * Servlet implementation class ShowAllBooksServlet
 */
@WebServlet("/ShowAllBooksServlet")
public class ShowAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServiceImpl bookservice = new BookServiceImpl();
		Map<String, Book> books = bookservice.findAllBooks();
		
		request.setAttribute("books", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/listBooks.jsp");
		dispatcher.forward(request, response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
