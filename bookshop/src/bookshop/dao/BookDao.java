package bookshop.dao;

import java.util.Map;

import bookshop.domain.Book;

public interface BookDao {

	Map<String, Book> getAllBook();

	Book getBookById(String bookid);

}