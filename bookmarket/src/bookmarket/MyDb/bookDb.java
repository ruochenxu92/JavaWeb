package bookmarket.MyDb;

import java.util.LinkedHashMap;
import java.util.Map;

import bookmarket.domain.Book;

public class bookDb {
	private static Map<String, Book> books = new LinkedHashMap<String,Book>();
	static{
		books.put("001", new Book("001", "JavaWeb Development", "aaaaa", 10, "good book"));

		books.put("002", new Book("002", "JavaWeb Spring", "bbbbb", 11, "great book"));

		books.put("003", new Book("003", "JavaWeb Hibernate", "ccccc", 12, "excellent book"));

		books.put("004", new Book("004", "JavaWeb Struct", "ddddd", 13, "very good book"));

		books.put("005", new Book("005", "JavaWeb Android", "eeeee", 14, "bad book"));

		books.put("006", new Book("006", "JavaWeb Struct2", "fffff", 15, "fantastic book"));
	}
	
	public static Map<String, Book> getAll(){
		return books;
	}
	/**
	 * 
	 * @param bookid
	 * @return Book
	 */
	public static Book getBookById(String bookid){
		return books.get(bookid);
	}		
}
