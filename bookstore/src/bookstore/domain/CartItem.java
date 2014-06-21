package bookstore.domain;

public class CartItem {
	private int num;
	private Book book;
	private double price;
	public CartItem(){}
	
	public CartItem(int num, Book book, double price) {
		super();
		this.num = num;
		this.book = book;
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
