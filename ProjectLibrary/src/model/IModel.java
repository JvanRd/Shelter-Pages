package model;

import java.util.ArrayList;

/**
 * This interface contains the methods that must be implemented by the model
 */
public interface IModel {
    public boolean registerUser(User user);
    public boolean checkUser(String name, String password);
    public boolean addBookToSection(String sectionName, Book book);
    public boolean addSection(Section section);
    public boolean addBookToCart(String bookTitle, String userName);
    public void deleteBooksUser(ArrayList<String> bookName, String userName);
    public void deleteAllBooks(String userName);
    public boolean buyBooksCart(String userName);
    public boolean addMoney(String userName, int money);
    public Book searchBookByTitle(String bookTitle);
    public void setUsersList(ArrayList<User> userList);
    public void setSectionList(ArrayList<Section> sectionList);
    public Object[][] getBooks(String getNameUser);
    public String getMoneyUser(String nameUser);
    public ArrayList<Book> searchBookByAuthor(String author);
    public User getUser(String nameUser);
    public ArrayList<User> getUsers();
    public void addOtherBooks(ArrayList<Book> books);
}
