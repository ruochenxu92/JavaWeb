package bookmarket.Dao;

import java.util.Map;

import bookmarket.MyDb.bookDb;
import bookmarket.domain.Book;

public class Dao {
	public Map findAll(){
		return bookDb.getAll();
	}
	
	public Book find(String bookid){
		return bookDb.getBookById(bookid);
	}
}
