package bookstore.util;

import java.util.LinkedHashMap;
import java.util.Map;

import bookstore.domain.Book;

public class BookDb {
	private static Map<String, Book> books = new LinkedHashMap<String,Book>();
	static{
		books.put("ISBN-001", new Book("ISBN-001", "JavaWeb Development", "aaaaa", 10, "good book"));

		books.put("ISBN-002", new Book("ISBN-002", "JavaWeb Spring", "bbbbb", 11, "great book"));

		books.put("ISBN-003", new Book("ISBN-003", "JavaWeb Hibernate", "ccccc", 12, "excellent book"));

		books.put("ISBN-004", new Book("ISBN-004", "JavaWeb Struct", "ddddd", 13, "very good book"));

		books.put("ISBN-005", new Book("ISBN-005", "JavaWeb Android", "eeeee", 14, "bad book"));

		books.put("ISBN-006", new Book("ISBN-006", "JavaWeb Struct2", "fffff", 15, "fantastic book"));
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