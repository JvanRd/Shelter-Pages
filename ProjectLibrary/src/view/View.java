package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * This class is the view for the library.
 * @author Juan
 * @version 29/05/2024
 */

public class View implements IView{
    private LogInFrame lif;
    private SingInFrame sif;
    private Facade facade;
    private Inside inside;
    private FantasySection fantasySection;
    private HorrorSection horrorSection;
    private RomanceSection romanceSection;
    private ArtSection artSection;
    private Basket basket;
    private EditBalance editBalance;
    private SearchSection searchSection;
    private Exclusive exclusive;

    /**
     * Constructor for the view
     * @param actionLisener
     */
    public View(ActionListener actionLisener){
        lif = new LogInFrame(actionLisener);
        lif.setVisible(true);
        sif = new SingInFrame(actionLisener);
        facade = new Facade(actionLisener);
        inside = new Inside(actionLisener);
        fantasySection = new FantasySection(actionLisener);
        horrorSection = new HorrorSection(actionLisener);
        artSection = new ArtSection(actionLisener);
        romanceSection = new RomanceSection(actionLisener);
        basket = new Basket(actionLisener);
        editBalance = new EditBalance(actionLisener);
        searchSection = new SearchSection(actionLisener);
        exclusive = new Exclusive(actionLisener);
    }

    /**
     * Sets the visibility of the sign up frame to true, making it visible on the screen.
     */
    @Override
    public void showSignUp() {
        sif.setVisible(true);
    }

    /**
     * Sets the visibility of the log in frame to true, making it visible on the screen.
     */
    @Override
    public void showLogIn() {
        sif.setVisible(false);
        lif.setVisible(true);
    }

    /**
     * Sets the visibility of the facade frame to true, making it visible on the screen.
     */
    @Override
    public void showFacade() {
        lif.setVisible(false);
        facade.setVisible(true);
    }

    /**
     * Sets the visibility of the inside frame to true, making it visible on the screen.
     */
    @Override
    public void showInside() {
        inside.setVisible(true);
    }

    /**
     * Sets the visibility of the fantasySection frame to true, making it visible on the screen.
     */
    @Override
    public void showFantasy() {
        fantasySection.setVisible(true);
    }

    /**
     * Sets the visibility of the HorrorSection frame to true, making it visible on the screen.
     */
    @Override
    public void showHorror() {
        horrorSection.setVisible(true);
    }

    /**
     * Sets the visibility of all the section frames to false and sets the inside frame to true, making it visible on the screen.
     */
    @Override
    public void showSections() {
        fantasySection.setVisible(false);
        horrorSection.setVisible(false);
        artSection.setVisible(false);
        romanceSection.setVisible(false);
        inside.setVisible(true);
    }

    /**
     * Sets the visibility of the artSection frame to true, making it visible on the screen.
     */
    @Override
    public void showArt() {
        artSection.setVisible(true);
    }

    /**
     * Sets the visibility of the romanceSection frame to true, making it visible on the screen.
     */
    @Override
    public void showCience() {
        romanceSection.setVisible(true);
    }

    /**
     * Sets the visibility of the inside frame to false, showing the facade frame on the screen.
     */
    @Override
    public void showOutside() {
        inside.setVisible(false);
    }

    /**
     * Sets the visibility of the basket frame to true, making it visible on the screen.
     * @param basketBooks
     */
    @Override
    public void showBasket(Object[][] basketBooks) {
        basket.setVisible(true);
        basket.showBasket(basketBooks);
    }

    /**
     * Sets the visibility of the basket frame to false.
     */
    @Override
    public void showSectionsFromBasket() {
        basket.setVisible(false);
    }

    /**
     * Sets the visibility of the editBalance frame to true, making it visible on the screen.
     */
    @Override
    public void showBalanceEdition() {
        editBalance.setVisible(true);
        editBalance.isAlwaysOnTop();
    }

    /**
     * Sets the visibility of the editBalance frame to false.
     */
    @Override
    public void quitBalanceEdition() {
        editBalance.setVisible(false);
    }

    /**
     * Sets the visibility of the search frame to true, making it visible on the screen.
     */
    @Override
    public void showSearch() {
        searchSection.setVisible(true);
    }

    /**
     * Sets the visibility of the search frame to false.
     */
    @Override
    public void showOutsideFromSearch() {
        searchSection.setVisible(false);
    }

    /**
     * Sets the visibility of the exclusive frame to true, making it visible on the screen.
     */
    @Override
    public void showExclusive() {
        exclusive.setVisible(true);
    }

    /**
     * Sets the visibility of the exclusive frame to false.
     */
    @Override
    public void quitExclusive() {
        exclusive.setVisible(false);
    }

    /**
     * Gets the data from the log in frame.
     */
    @Override
    public List<String> getData() {
        List<String> data = new ArrayList();
        data.add(lif.getTfu().getText());
        data.add(lif.getTfp().getText());
        return data;
    }

    /**
     * Sets the visibility of all the frames to false.
     */
    @Override
    public void disguise(){
        lif.setVisible(false);
        facade.setVisible(false);
        inside.setVisible(false);
        fantasySection.setVisible(false);
        horrorSection.setVisible(false);
        romanceSection.setVisible(false);
        artSection.setVisible(false);
        inside.setVisible(false);
        basket.setVisible(false);
    }
    
    /**
     * Gets the name of the user from the log in frame.
     */
    @Override
    public String getNameUser() {
        return lif.getTfu().getText();
    }

    /**
     * Shows the information of the user in the basket frame.
     */
    @Override
    public void showInfo(String nameUser, String money) {
        basket.showInfo(nameUser, money);
    }

    /**
     * Cleans the table in the basket frame.
     */
    @Override
    public void cleanTable(String newMoney) {
        Object[][] books = new Object[0][0];
        basket.showBasket(books);
        basket.showInfo("", newMoney);
    }

    /**
     * Shows the information of the user in the editBalance frame.
     */
    @Override
    public void showEditBalance(Object[][] basketBooks, String user, String money) {
        basket.setVisible(false);
        editBalance.setVisible(true);
        editBalance.setInfo(basketBooks, user, money);
    }

    @Override
    public void showPaneMessage(String s) {
        JOptionPane.showMessageDialog(null,s);
    }
}
