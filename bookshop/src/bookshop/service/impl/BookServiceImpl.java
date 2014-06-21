package bookshop.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import bookshop.dao.impl.BookDaoImpl;
import bookshop.domain.Book;

public class BookServiceImpl implements BookService {
	private Map<String, Book> map = new LinkedHashMap<String, Book>();
	private BookDaoImpl bookdao = new BookDaoImpl();
	public BookServiceImpl(){}
	
	@Override
	public Map<String, Book> findAllBooks(){
		map = bookdao.getAllBook();
		return map; 
	}
	
	@Override
	public Book getBookById(String bookid){
		Book book = bookdao.getBookById(bookid);
		return book;
	}
	
}
