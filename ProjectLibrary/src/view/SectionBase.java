package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import presenter.FileManager;

/**
 * SectionBase class extends BigFrames
 * This class sets the aset for section frames, it sets the size, icon and a font.
 * @author Juan
 * @version 29/05/2024
 */

public class SectionBase extends BigFrames{

    private JPanel backgroundP;
    private JPanel booksPanel;
    private Icon back;
    private JButton backButton;
    private Icon basket;
    private JButton basketButton;
    private Font Bogart;
    private Font Happy;
    private Font aston;

    /**
     * SectionBase constructor
     * @param presenter
     */
    public SectionBase(ActionListener presenter){

        back = new ImageIcon( FileManager.getValue("urlBack"));

        try {
            Bogart = Font.createFont(Font.TRUETYPE_FONT, new File( "resources/Bogart-Bold-trial.ttf")).deriveFont(Font.BOLD,36);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Happy = Font.createFont(Font.TRUETYPE_FONT, new File( "resources/Simply-Happy.otf")).deriveFont(Font.BOLD,24);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            aston = Font.createFont(Font.TRUETYPE_FONT, new File( "resources/Astonpoliz.otf")).deriveFont(Font.BOLD,16);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        backButton= new JButton(back);
        backButton.setBorder(new LineBorder(Colour.DARK_BG));
        backButton.setBounds(10, 10, 51, 55);
        backButton.addActionListener(presenter);
        backButton.setActionCommand("backToSection");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        basket = new ImageIcon( FileManager.getValue("urlBasket"));
        basketButton = new JButton(basket);
        basketButton.setBorder(new LineBorder(Colour.DARK_BG));
        basketButton.setBounds(10, 10, 51, 55);
        basketButton.addActionListener(presenter);
        basketButton.setActionCommand("basket");

        backgroundP = new JPanel();
        backgroundP.setSize(750, 590);
        backgroundP.setLayout(null);
        backgroundP.setBackground(Colour.DARK_BG);

        booksPanel = new JPanel();
        booksPanel.setBounds(75, 65, 1380, 700);
        booksPanel.setLayout(null);
        booksPanel.setBorder(new MatteBorder(18, 18, 18, 18, Colour.CHOCO));

        backgroundP.add(booksPanel);
        backgroundP.add(backButton);
        this.add(backgroundP);
    }

     /**
     * Returns the background panel of SectionBase.
     *
     * @return  the background panel of SectionBase
     */
    public JPanel getBackgroundP() {
        return backgroundP;
    }

    /**
     * Sets the background panel of SectionBase.
     *
     * @param  backgroundP  the JPanel representing the background panel of SectionBase
     */
    public void setBackgroundP(JPanel backgroundP) {
        this.backgroundP = backgroundP;
    }

    /**
     * Returns the JPanel representing the books panel of SectionBase.
     *
     * @return  the JPanel representing the books panel of SectionBase
     */

    public JPanel getBooksPanel() {
        return booksPanel;
    }

    /**
     * Sets the books panel for this object.
     *
     * @param  booksPanel  the JPanel representing the books panel
     */
    public void setBooksPanel(JPanel booksPanel) {
        this.booksPanel = booksPanel;
    }

    /**
     * Returns the Bogart font object.
     *
     * @return  the Bogart font object
     */
    public Font getBogart() {
        return Bogart;
    }

    /**
     * Sets the Bogart font object.
     *
     * @param  bogart  the Font object representing the Bogart font
     */
    public void setBogart(Font bogart) {
        Bogart = bogart;
    }

    /**
     * Returns the Happy Font object.
     *
     * @return  the Happy Font object
     */
    public Font getHappy() {
        return Happy;
    }

    /**
     * Sets the Happy Font object.
     *
     * @param  happy  the Font object representing the Happy font
     */
    public void setHappy(Font happy) {
        Happy = happy;
    }

    /**
     * Returns the Aston Font object.
     *
     * @return  the Aston Font object
     */
    public Font getAston() {
        return aston;
    }

    /**
     * Sets the Aston font for this object.
     *
     * @param aston the Aston font to be set
     */
    public void setAston(Font aston) {
        this.aston = aston;
    }

    
}
