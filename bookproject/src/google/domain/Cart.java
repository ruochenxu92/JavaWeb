package google.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	 private double price;
	 private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
	public double getPrice() {
		 
	   return 1.9;
	}
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	
	//put book on cart
	public void addBook(Book book){
		//First you need to judge whether the book has been put in 
		//cart before, if we have , num++ else put the book on he cart
		String bookid = book.getId();
		boolean has = map.containsKey(bookid);
		
		if(has){
			CartItem item = map.get(bookid);
			item.setNum(item.getNum()+1);
		}else{
			CartItem item = new CartItem();
			item.setBook(book);
			item.setNum(1);
			map.put(bookid, item);
		}
	}
}
