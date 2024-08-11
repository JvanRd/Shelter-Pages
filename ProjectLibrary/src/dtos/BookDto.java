package dtos;

import model.Book;

public class BookDto {
    private String name;
    private String author;
    private String price;

    /**
     * Creates a new BookDto object.
     * @param name
     * @param author
     * @param price
     */
    public BookDto(String name, String author, String price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    /**
     * Converts a BookDto object to a Book object.
     *
     * @param  bookDto  the BookDto object to convert
     * @return          the converted Book object
     */
    public static Book fromBookDto(BookDto bookDto) {
        Book book = new Book(bookDto.getName(), bookDto.getAuthor(), Integer.parseInt(bookDto.getPrice()));
        return book;
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
     * Returns the author of the object.
     *
     * @return the author of the object
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
     * Returns the price of the object.
     *
     * @return the price of the object as a string
     */
    public String getPrice() {
        return price;
    }
    /**
     * Sets the price of the object.
     *
     * @param  price  the new price for the object as a string
     */
    public void setPrice(String price) {
        this.price = price;
    }

    
}
