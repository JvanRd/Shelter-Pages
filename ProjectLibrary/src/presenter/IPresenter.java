package presenter;

import java.util.ArrayList;

import dtos.BookDto;

/**
 * This interface contains the methods that must be implemented by the presenter
 */

public interface IPresenter {
    public void init();
    public void addOtherBooks(ArrayList<BookDto> bookList);
    public void backtoLogIn();
    public void deleteBasket(Object source);
    public void acceptBalance(Object source);
    public void showEditBalance();
    public void backFromEditBalance(Object source);
    public void searchBook(Object source);
    public void buyBasket();
    public void login(Object source);
    public void showFantasy();
    public void showHorror();
    public void showArt();
    public void showRomance();
    public void addMaleducada();
    public void addBlindes();
    public void addBoulevard();
    public void addAlicia();
    public void addCazadores();
    public void addNarnia();
    public void addReina();
    public void addChica();
    public void addBazar();
    public void addGato();
    public void addLady();
    public void addMonet();
    public void addBarroca();
    public void addParaiso();
    public void addFealdad();
    public void addOrgullo();
    public void addHeart();
    public void addInvierno();
    public void addDyl();
    public void backToSection(Object source);
    public void goBasket();
    public void backOutSide();
    public void backFromBasket();
    public void backFromSearch();
    public void backFromExclusive();
    public void createAccount();
    public void createAccount(Object source);
}
