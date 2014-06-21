package bookmarket.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {
	private Map<String, CartItem> map = new LinkedHashMap();
	private double price;
	public Cart(){}
	
	public Map<String, CartItem> getMap() {
		return map;
	}


	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}



	public double getPrice() {
		double total = 0;
		for(Entry<String, CartItem> entry : map.entrySet()){
			total += entry.getValue().getPrice();
		}
		return total;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void addBook(Book book){
		String bookid = book.getId();
		if(map.containsKey(bookid)){
			int quantity = map.get(bookid).getQuantity();
			map.get(bookid).setQuantity(quantity+1);
		}else{
			CartItem item = new CartItem();
			item.setBook(book);
			item.setPrice(book.getPrice());
			item.setQuantity(1);
		    map.put(bookid,item);
		}
	}
	
	
}
