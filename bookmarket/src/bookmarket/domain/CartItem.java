package bookmarket.domain;

public class CartItem {
	private int quantity;
	private Book book;
	private double price;
	public CartItem(){}
	
	
	public double getPrice() {
		return book.getPrice() * this.quantity;//really trick thing!!!!!!!!!!!
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
