package model;

import java.util.ArrayList;

/**
 * This class represents a user of the library.
 */
public class User {
	private String name;
	private String password;
	private int money;
	private ArrayList<Book> shoppingCart;
	private int priceInCart;

	public User(String name, String password, int money) {
		this.name = name;
		this.password = password;
		this.money = money;
		this.shoppingCart = new ArrayList<Book>();
	}

	/**
	 * Adds a book to the shopping cart of the user.
	 *
	 * @param  book  the book object to be added to the cart
	 * @return       true if the book was successfully added to the cart, false otherwise
	 */
	public boolean addBookToCart(Book book) {
		shoppingCart.add(book);
		priceInCart += book.getPrice();
		return true;
	}

	/**
	 * Deletes a book from the user's shopping cart based on the book name.
	 *
	 * @param  bookName  the name of the book to be deleted
	 */
	public void deleteBookUser(ArrayList<String> booksName) {
		shoppingCart.removeIf(book -> booksName.contains(book.getName()));
		validatePriceInCart();
	}
	/**
	 * Calculates the total price of all books in the shopping cart and updates the priceInCart field.
	 *
	 * This method iterates over each book in the shoppingCart ArrayList and adds the price of each book to the priceInCart field.
	 * The priceInCart field is initially set to 0 before the loop.
	 *
	 * @return void
	 */
	private void validatePriceInCart() {
		priceInCart = 0;
		for (Book book : shoppingCart) {
			priceInCart += book.getPrice();
		}
	}

	/**
	 * Buys the books in the shopping cart of the user if the user has enough money.
	 *
	 * @return  true if the books were successfully bought, false otherwise
	 */
	public boolean buyBooksCart() {
		if (money >= priceInCart) {
			shoppingCart = new ArrayList<>();
			money -= priceInCart;
			priceInCart = 0;
			return true;
		}
		return false;
	}

	/**
	 * Deletes all books from the user's shopping cart.
	 */
	public void deleteAllBooks() {
		shoppingCart.clear();
	}

	
	/**
	 * Adds the specified amount of money to the user's account.
	 *
	 * @param  moneyToAdd  the amount of money to be added
	 */
    public boolean addMoney(int moneyToAdd) {
		money += moneyToAdd;
		return true;
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
	 * Returns the password of the user.
	 *
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password for the user.
	 *
	 * @param  password  the new password for the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the amount of money held by the user.
	 *
	 * @return the amount of money held by the user
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Sets the amount of money held by the user.
	 *
	 * @param  money  the new amount of money for the user
	 */
	public void setMoney(int money) {
		this.money = money;
	}

		/**
		 * Sets the price in the shopping cart for the user.
		 *
		 * @param  priceInCart  the new price in the shopping cart for the user
		 */
	public void setPriceInCart(int priceInCart) {
		this.priceInCart = priceInCart;
	}

		/**
		 * Returns a string representation of the User object.
		 *
		 * @return a string representation of the User object
		 */
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", money=" + money + ", shoppingCart=" + shoppingCart
				+ "]";
	}

	/**
	 * Sets the shopping cart for the user.
	 *
	 * @param  shoppingCart  the new shopping cart for the user
	 */
	public void setShoppingCart(ArrayList<Book> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	/**
	 * Returns the price in the shopping cart for the user.
	 *
	 * @return the price in the shopping cart for the user
	 */
	public int getPriceInCart() {
		return priceInCart;
	}

	
		/**
		 * Retrieves the books in the shopping cart of the user as a 2D array of Object.
		 *
		 * @return a 2D array of Object where each row represents a book and the first column contains the book's name and the second column contains the book's price.
		 */
    public Object[][] getBooks() {
		Object[][] books = new Object[shoppingCart.size()][2];
		for (int i = 0; i < shoppingCart.size(); i++) {
			books[i][0] = shoppingCart.get(i).getName();
			books[i][1] = shoppingCart.get(i).getPrice();
		}
		return books;
    }


	/**
	 * Returns the shopping cart of the user, which is an ArrayList of Book objects.
	 *
	 * @return  an ArrayList of Book objects representing the user's shopping cart
	 */
	public ArrayList<Book> getShoppingCart() {
		return shoppingCart;
	}

	


}
