package view;

import java.util.List;

/**
 * This IVew interface contains the methods that must be implemented by the view
 * @author Juan
 * @version 29/05/2024
 */

public interface IView {
    
    public void showSignUp();
    public void showLogIn();
    public void showFacade();
    public void showInside();
    public void showFantasy();
    public void showHorror();
    public void showArt();
    public void showSections();
    public void showCience();
    public void showOutside();
    public void showBasket(Object[][] basketBooks);
    public void showSectionsFromBasket();
    public void showBalanceEdition();
    public void quitBalanceEdition();
    public void showSearch();
    public void showOutsideFromSearch();
    public void showExclusive();
    public void quitExclusive();
    public List<String> getData();
    public void disguise();
    public String getNameUser();
    public void showInfo(String nameUser, String money);
    public void cleanTable(String nameUser);
    public void showEditBalance(Object[][] basketBooks, String user, String money);
    public void showPaneMessage(String s);
}
