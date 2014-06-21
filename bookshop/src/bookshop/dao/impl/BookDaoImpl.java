package bookshop.dao.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import bookshop.dao.BookDao;
import bookshop.domain.Book;
import bookshop.util.BookDb;

public class BookDaoImpl implements BookDao {
	
	@Override
	public   Map<String, Book> getAllBook(){
		return BookDb.getAll();
	}
	
	@Override
	public   Book getBookById(String bookid){
		return BookDb.getBookById(bookid);
	}
	
	
}
