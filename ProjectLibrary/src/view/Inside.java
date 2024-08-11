package view;

import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import presenter.FileManager;

/**
 * Inside class extends BigFrames
 * This frame shows teh inside of the library shown the sections in the library.
 * Using a JButton to go back to the outside of the library and another to show the basket.
 * @author Juan
 * @version 29/05/2024
 */

public class Inside extends BigFrames{

    private ImageIcon back;
    private JButton backButton;
    private ImageIcon fantasy;
    private JButton fantasyB;
    private ImageIcon horror;
    private JButton horrorB;
    private ImageIcon art;
    private JButton artB;
    private ImageIcon cience;
    private JButton cienceB;
    private ImageIcon basket;
    private JButton basketB;
    private JPanel backgroundP;

    /**
     * Inside constructor.
     * @param presenter
     */

    public Inside(ActionListener presenter){
        
        backgroundP = new JPanel();
        this.setTitle("Shelter Pages - Sections");

        back = new ImageIcon( FileManager.getValue("urlDoorIcon"));
        backButton = new JButton(back);
        backButton.setBounds(10, 10, 60, 60);
        backButton.setBorder(new LineBorder(Colour.DARK_BG));
        backButton.addActionListener(presenter);
        backButton.setActionCommand("backOutside");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backgroundP.add(backButton);

        backgroundP.setSize(750, 590);
        backgroundP.setLayout(null);
        backgroundP.setBackground(Colour.DARK_BG);

        basket = new ImageIcon( FileManager.getValue("urlBasket"));
        basketB = new JButton(basket);
        basketB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        basketB.setBounds(740, 750, 90, 90);
        basketB.setBorder(new LineBorder(Colour.DARK_BG));
        basketB.setActionCommand("goBasket");
        basketB.addActionListener(presenter);
        backgroundP.add(basketB);

        fantasy = new ImageIcon( FileManager.getValue("urlFantasy"));
        fantasyB = new JButton(fantasy);
        fantasyB.addActionListener(presenter);
        fantasyB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fantasyB.setActionCommand("fantasy");
        fantasyB.setBounds(100, 5, 300, 745);
        backgroundP.add(fantasyB);

        horror = new ImageIcon( FileManager.getValue("urlHorror"));
        horrorB = new JButton(horror);
        horrorB.addActionListener(presenter);
        horrorB.setActionCommand("horror");
        horrorB.setBounds(450, 5, 300, 745);
        horrorB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backgroundP.add(horrorB);

        art = new ImageIcon( FileManager.getValue("urlArt"));
        artB = new JButton(art);
        artB.addActionListener(presenter);
        artB.setActionCommand("art");
        artB.setBounds(800, 5, 300, 745);
        artB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backgroundP.add(artB);

        cience = new ImageIcon( FileManager.getValue("urlRomance"));
        cienceB = new JButton(cience);
        cienceB.addActionListener(presenter);
        cienceB.setActionCommand("romance");
        cienceB.setBounds(1150, 5, 300, 745);
        cienceB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backgroundP.add(cienceB);

        this.add(backgroundP);
    }
}
