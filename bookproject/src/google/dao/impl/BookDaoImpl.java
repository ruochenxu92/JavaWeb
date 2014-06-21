package google.dao.impl;

import java.util.Map;

import google.dao.BookDao;
import google.domain.Book;
import google.util.BookDb;
public class BookDaoImpl implements BookDao {
	@Override
	public Map<String, Book> findAllBook(){
		return BookDb.getAll();
	}
	
	@Override
	public Book findBookById(String bookid){
		return BookDb.getBookById(bookid);
	}
	
	
	
	
	
	
}
