package bookstore.dao.impl;

import java.util.Map;

import bookstore.dao.BookDao;
import bookstore.domain.Book;
import bookstore.util.BookDb;

public class BookDaoImpl implements BookDao {
	
	
	@Override
	public Map<String, Book> getAll(){
		return BookDb.getAll();
	}
	
	@Override
	public Book getBookById(String bookid){
		return BookDb.getBookById(bookid);
	}
	
	
	
}
