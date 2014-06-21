package bookstore.dao;

import java.util.Map;

import bookstore.domain.Book;

public interface BookDao {

	Map<String, Book> getAll();

	Book getBookById(String bookid);

}