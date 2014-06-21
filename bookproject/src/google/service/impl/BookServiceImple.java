package google.service.impl;

import google.dao.BookDao;
import google.dao.impl.BookDaoImpl;
import google.domain.Book;
import google.service.BookService;

import java.util.Map;

public class BookServiceImple implements BookService {
	BookDao dao = new BookDaoImpl();
	@Override
	public Map<String, Book> findAllBook(){
		return dao.findAllBook();
	}
	
}
