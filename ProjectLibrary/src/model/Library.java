package model;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * This class represents the library.
 */
public class Library implements IModel {
	private ArrayList<Section> sections;
	private ArrayList<User> users;
	private ArrayList<Book> otherBooks;

	public Library() {
		sections = new ArrayList<Section>();
		users = new ArrayList<User>();
	}
		/**
		 * Sets the list of other books for this Library.
		 *
		 * @param  otherBooks  the new list of other books for this Library
		 */
@Override
	public void addOtherBooks(ArrayList<Book> otherBooks) {
		this.otherBooks = otherBooks;
	}

	/**
	 * Registers a new user in the system.
	 *
	 * @param  user  the user object to be registered
	 * @return       true if the user is successfully registered, false otherwise
	 */
	@Override
	public boolean registerUser(User user) {
		boolean isExists = isExists(user.getName());
		boolean isExistsName = isExistName(user.getName());
		if (!isExists && !isExistsName) {
			users.add(user);
			return true;
		}
		return false;
	}

		/**
		 * Checks if a user with the given name and password exists in the system.
		 *
		 * @param  name     the name of the user to check
		 * @param  password the password of the user to check
		 * @return          true if a user with the given name and password exists, false otherwise
		 */
	@Override
	public boolean checkUser(String name, String password) {
		BiPredicate<String, String> credentialsMatch = (userName, userPassword) ->
        userName.equals(name) && userPassword.equals(password);
    
    			return users.stream()
                .anyMatch(user -> credentialsMatch.test(user.getName(), user.getPassword()));
	}

	/**
	 * Adds a book to a section with the specified name.
	 *
	 * @param  sectionName the name of the section to add the book to
	 * @param  book        the book object to be added
	 * @return             true if the book is successfully added to the section, false otherwise
	 */
	@Override
	 public boolean addBookToSection(String sectionName, Book book) {
		boolean isAdd = false;
		for (Section section : sections) {
			if (section.getSectionName().toLowerCase().equals(sectionName.toLowerCase())) {
				isAdd = section.addBook(book);
			}
		}
		return isAdd;
	}

	/**
	 * Adds a section to the list of sections if it does not already exist.
	 *
	 * @param  section  the section to be added
	 * @return          true if the section is successfully added, false if a section with the same name already exists
	 */
	@Override
	 public boolean addSection(Section section) {
		for (Section sectionList : sections) {
			if (sectionList.getSectionName().toLowerCase().equals(section.getSectionName().toLowerCase())) {
				return false;
			}
		}
		sections.add(section);
		return true;
	}

		/**
		 * Adds a book to the shopping cart of a user if the book exists and the user exists.
		 *
		 * @param  bookTitle the title of the book to be added to the cart
		 * @param  userName  the name of the user whose cart the book will be added to
		 * @return           true if the book was successfully added to the user's cart, false otherwise
		 */
	@Override
	public boolean addBookToCart(String bookTitle, String userName) {
		boolean isAdd = false;
		Book book = searchBookByTitle(bookTitle);
		for (User user : users) {
			if (user.getName().equals(userName)) {
				isAdd = user.addBookToCart(book);
			}
		}
		return isAdd;	
	}

	/**
	 * Deletes a book from the user's shopping cart if the book and user exist.
	 *
	 * @param  bookName the title of the book to be deleted from the user's cart
	 * @param  userName the name of the user whose cart the book will be deleted from
	 */
	@Override
	public void deleteBooksUser(ArrayList<String> bookName, String userName) {
		for (User user : users) {
			if (user.getName().equals(userName)) {
				user.deleteBookUser(bookName);
			}
		}
	}

	/**
	 * Deletes all books from the user's shopping cart if the user exists.
	 *
	 * @param  userName  the name of the user whose cart the books will be deleted from
	 */
	@Override
	public void deleteAllBooks(String userName) {
		for (User user : users) {
			if (user.getName().equals(userName)) {
				user.deleteAllBooks();
			}
		}
	}

		/**
		 * Returns the User object with the specified nameUser from the list of users.
		 *
		 * @param  nameUser  the name of the user to retrieve
		 * @return           the User object with the specified nameUser, or null if not found
		 */
	@Override
	public User getUser(String nameUser) {
		for (User user : users) {
			if (user.getName().equals(nameUser)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * Buys the books in the shopping cart of a user if the user exists.
	 *
	 * @param  userName  the name of the user whose cart the books will be bought from
	 * @return           true if the books were successfully bought, false otherwise
	 */
	@Override
	public boolean buyBooksCart(String userName) {
		Predicate<User> userPredicate = user -> user.getName().equals(userName);
    	return users.stream()
                .filter(userPredicate)
                .findFirst()
                .map(User::buyBooksCart)
                .orElse(false);
	}

	/**
	 * Adds the specified amount of money to the user's account with the given username.
	 *
	 * @param  userName  the username of the user whose account will be credited
	 * @param  money    the amount of money to be added to the user's account
	 */
	@Override
	public boolean addMoney(String userName, int money) {
		boolean isAdd = false;
		for (User user : users) {
			if (user.getName().equals(userName)) {
				isAdd = user.addMoney(money);
			}
		}
		return isAdd;
	}

		/**
		 * Searches for a book with the given title in all sections of the library.
		 *
		 * @param  bookTitle the title of the book to search for
		 * @return           the book with the given title, or null if no such book exists
		 */
	@Override
	public Book searchBookByTitle(String bookTitle) {
		Book bookToSearch = null;
		for (Section section : sections) {
			if (bookToSearch == null) {
				bookToSearch = section.searchBook(bookTitle);
			}
		}
		if (bookToSearch == null) {
			for (Book book : otherBooks) {
				if (book.getName().toLowerCase().replace(" ", "").equals(bookTitle.toLowerCase().replace(" ", ""))) {
					bookToSearch = book;
				}
			}
		}
		return bookToSearch;
	}

		/**
		 * Searches for books by the given author in all sections of the library and in the list of other books.
		 *
		 * @param  author the author of the books to search for
		 * @return        an ArrayList of Book objects representing the books by the given author
		 */
	@Override
	public ArrayList<Book> searchBookByAuthor(String author) {
		ArrayList<Book> booksToSearch = new ArrayList<Book>();
		for (Section section : sections) {
			ArrayList<Book> books = section.searchBooksByAuthor(author);
			for (Book book : books) {
				booksToSearch.add(book);
			}
		}
		for (Book book : otherBooks) {
			if (book.getAuthor().equals(author)) {
				booksToSearch.add(book);
			}
		}
		return booksToSearch;
	}

		/**
		 * Retrieves the books owned by a user with the specified name.
		 *
		 * @param  getNameUser  the name of the user whose books are to be retrieved
		 * @return              a 2D array of Object representing the books owned by the user, or null if no user with the specified name is found
		 */
	@Override
	public Object[][] getBooks(String getNameUser) {
		Object[][] books = null;
		for (User user : users) {
			if (user.getName().equals(getNameUser)) {
				books = user.getBooks();
			}
		}
		return books;
	}

	
	@Override
	public String getMoneyUser(String nameUser) {
		String money = null;
		for (User user : users) {
			if (user.getName().equals(nameUser)) {
				money = user.getMoney() + "";
			}
		}
		return money;
	}


	/**
	 * Checks if a user with the given username exists in the list of users.
	 *
	 * @param  userName  the username of the user to check
	 * @return           true if a user with the given username exists, false otherwise
	 */
	private boolean isExists(String userName) {
		boolean isExists = false;
		for (User userList : users) {
			if (userList.getName().toLowerCase().replace(" ", "").equals(userName.toLowerCase().replace(" ", ""))) {
				isExists = true;
			}
		}
		return isExists;
	}

	/**
	 * Checks if a user with the given name already exists in the list of users.
	 *
	 * @param  name  the name of the user to check
	 * @return       true if a user with the given name exists, false otherwise
	 */
	private boolean isExistName(String name) {
		boolean isExistsName = false;
		for (User userList : users) {
			if (userList.getName().toLowerCase().replace(" ", "").equals(name.toLowerCase().replace(" ", ""))) {
				isExistsName = true;
			}
		}
		return isExistsName;
	}

		/**
		 * Sets the list of users in the object.
		 *
		 * @param  userList  the new list of users
		 */
	@Override
	public void setUsersList(ArrayList<User> userList) {
		this.users = userList;
	}

		/**
		 * Sets the list of sections in the object.
		 *
		 * @param  sectionList  the new list of sections
		 */
	@Override
	public void setSectionList(ArrayList<Section> sectionList) {
		this.sections = sectionList;
	}

		/**
		 * Returns the list of users in the object.
		 *
		 * @return  an ArrayList of User objects representing the list of users
		 */
	@Override
	public ArrayList<User> getUsers() {
		return users;
	}
}
