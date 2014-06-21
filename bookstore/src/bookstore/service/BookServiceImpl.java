package bookstore.service;

import java.util.Map;

import bookstore.dao.BookDao;
import bookstore.dao.impl.BookDaoImpl;
import bookstore.domain.Book;
import bookstore.service.impl.BookService;

public class BookServiceImpl implements BookService {
	BookDao dao = new BookDaoImpl();
	@Override
	public Map<String, Book> findAllBooks(){
		return dao.getAll();
	}
	
	@Override
	public Book findBookById(String bookid){
		return dao.getBookById(bookid);
	}
}
