package google.service;

import google.domain.Book;

import java.util.Map;

public interface BookService {

	Map<String, Book> findAllBook();

}