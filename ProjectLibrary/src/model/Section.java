package model;


import java.util.ArrayList;

/**
 * This class represents a section of the library.
 */
public class Section {
	private String sectionName;
	private ArrayList<Book> books;

	public Section(String sectionName) {
		this.sectionName = sectionName;
		this.books = new ArrayList<Book>();
	}

	/**
	 * Adds a book to the list of books if it does not already exist.
	 *
	 * @param  newBook	the book object to be added
	 * @return         	true if the book was successfully added, false otherwise
	 */
	public boolean addBook(Book newBook){
		for (Book book : books) {
			if (book.getName().equals(newBook.getName())) {
				return false;
			}
		}
		books.add(newBook);
		return true;
	}

	/**
	 * Searches for a book with the given name in the list of books.
	 *
	 * @param  bookName the name of the book to search for
	 * @return          the book with the given name, or null if no such book exists
	 */
	public Book searchBook(String bookName) {
		for (Book book : books) {
			if (book.getName().toLowerCase().replace(" ", "").equals(bookName.toLowerCase().replace(" ", ""))) {
				return book;
			}
		}
		return null;
	}

	/**
	 * Returns the name of the section.
	 *
	 * @return the name of the section
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * Sets the name of the section.
	 *
	 * @param  sectionName  the new name for the section
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * Returns the list of books in the section.
	 *
	 * @return an ArrayList of Book objects representing the books in the section
	 */
	public ArrayList<Book> getBooks() {
		return books;
	}

	/**
	 * Searches for books by the given author in the list of books.
	 *
	 * @param  author the author of the books to search for
	 * @return        an ArrayList of Book objects representing the books by the given author
	 */
	public ArrayList<Book> searchBooksByAuthor(String author) {
		ArrayList<Book> booksToSearch = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getAuthor().toLowerCase().replace(" ", "").equals(author.toLowerCase().replace(" ", ""))) {
				booksToSearch.add(book);
			}
		}
		return booksToSearch;
	}

	/**
	 * Sets the list of books for this Section.
	 *
	 * @param  books  the new list of books for this Section
	 */
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

		/**
		 * Returns a string representation of the Section object.
		 *
		 * @return a string in the format "Section [sectionName=<sectionName>, books=<books>]"
		 */
	@Override
	public String toString() {
		return "Section [sectionName=" + sectionName + ", books=" + books + "]";
	}



}
