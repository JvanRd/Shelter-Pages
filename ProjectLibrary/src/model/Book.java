package model;

/**
 * This class represents a book in the library.
 */
public class Book {
	private String name;
	private String author;
	private int price;

	/**
	 * Constructor of the Book class.
	 * @param name
	 * @param author
	 * @param price
	 */
	public Book(String name, String author, int price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}

	/**
	 * Returns the name of the object.
	 *
	 * @return the name of the object
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the object.
	 *
	 * @param  name  the new name for the object
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the author of the book.
	 *
	 * @return the author of the book
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author of the object.
	 *
	 * @param  author  the new author for the object
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Returns the price of the book.
	 *
	 * @return the price of the book
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of the object.
	 *
	 * @param  price  the new price for the object
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	

		/**
		 * Returns a string representation of the Book object.
		 *
		 * @return a string in the format "Book [name=<name>, author=<author>]"
		 */
	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + "]";
	}

}
