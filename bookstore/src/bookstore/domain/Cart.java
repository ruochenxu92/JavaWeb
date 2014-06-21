package bookstore.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();
	private int totalPrice;
	private int totalNum;

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	public int getTotalPrice() {
		totalPrice = 0;
		for (String key : map.keySet()) {
			CartItem item = map.get(key);
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}

	public int getTotalNum() {
		totalNum = 0;
		for (String key : map.keySet()) {
			CartItem item = map.get(key);
			totalNum += item.getNum();
		}
		return totalNum;
	}

	public void addBook(Book book) {
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
	
	public void deleteCartItem(String bookid){
		map.remove(bookid);
	}
	
	

}
