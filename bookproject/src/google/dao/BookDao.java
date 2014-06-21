package google.dao;

import google.domain.Book;

import java.util.Map;

public interface BookDao {

	Map<String, Book> findAllBook();

	Book findBookById(String bookid);

}