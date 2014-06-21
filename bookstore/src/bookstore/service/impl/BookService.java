package bookstore.service.impl;

import java.util.Map;

import bookstore.domain.Book;

public interface BookService {

	Map<String, Book> findAllBooks();

	Book findBookById(String bookid);
}