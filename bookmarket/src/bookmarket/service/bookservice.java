package bookmarket.service;

import java.util.Map;

import bookmarket.Dao.Dao;
import bookmarket.domain.Book;
import bookmarket.domain.Cart;
import bookmarket.domain.CartItem;
import bookmarket.exception.CartNotFoundException;

public class bookservice {
	private Dao dao = new Dao();
	
	public Map findAll(){
		return dao.findAll();
	}
	
	public Book find(String bookid){
		return dao.find(bookid);
	}
	
	public void buybook(String bookid, Cart cart){
		Book book = dao.find(bookid);
		cart.addBook(book);
	}

	public void delete(String bookid, Cart cart) throws CartNotFoundException {
		if(cart == null){
			throw new CartNotFoundException("Cart is empty!!");
		}

		Map map = cart.getMap();
		map.remove(bookid);
		
	}

	public void clear(Cart cart) throws CartNotFoundException {
		if(cart == null){
			throw new CartNotFoundException("Cart is empty!!");
		}
		cart.getMap().clear();
	
	}


	public void updateCart(String bookid, int quantity, Cart cart) throws CartNotFoundException {
		if(cart == null){
			throw new CartNotFoundException("Cart is empty!!");
		}
		CartItem  item = cart.getMap().get(bookid);
		item.setQuantity(quantity);
		
	}
}
