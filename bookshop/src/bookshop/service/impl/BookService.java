package bookshop.service.impl;

import java.util.Map;

import bookshop.domain.Book;

public interface BookService {

	Map<String, Book> findAllBooks();

	Book getBookById(String bookid);

}