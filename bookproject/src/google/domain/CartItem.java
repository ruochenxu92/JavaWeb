package google.domain;

public class CartItem {
	private Book book;
	private int num;
	private double price;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return book.getPrice()*num;
	}
	
	
}
