package bookshop.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String, CartItem> map = new LinkedHashMap();
	private int num;
	private double price;
	
	
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void addBook(Book book){
		//if we have the book, number ++ else create new CartItem and number is 1
		boolean has = map.containsKey(book.getId());
		if(has){
			CartItem item = map.get(book.getId());
			item.setNum(item.getNum()+1);
		}else{
			CartItem item = new CartItem();
			item.setBook(book);
			item.setNum(1);
			item.setPrice(book.getPrice());
		}
	}
	
	
	
}
