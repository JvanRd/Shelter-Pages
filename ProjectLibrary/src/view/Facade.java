package view;

import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import presenter.FileManager;

/**
 * Facade class extends BigFrames
 * This class sets the aset for anther frames, it sets the size, icon and a font.
 * @author Juan
 * @version 29/05/2024
 */

public class Facade extends BigFrames{
    private ImageIcon back;
    private JButton backButton;
    private Icon door;
    private JButton doorButton;
    private Icon search;
    private JButton searchButton;
    private Icon exclusive;
    private JButton exclusiveButton;
    private JPanel backgroundP;

    /**
     * Facade constructor
     * @param presenter
     */

    public Facade(ActionListener presenter){

        this.setTitle("Shelter Pages");

        door = new ImageIcon( FileManager.getValue("urlDoor"));
        backgroundP = new JPanel();
        searchButton = new JButton();
        doorButton = new JButton(door);
        doorButton.addActionListener(presenter);
        doorButton.setActionCommand("door");

        backgroundP.setSize(750, 590);
        backgroundP.setLayout(null);
        backgroundP.setBackground(Colour.LIGHT_BG);
        doorButton.setBounds(250, 140, 418, 701);
        backgroundP.add(doorButton);

        back = new ImageIcon( FileManager.getValue("urlDoorLight"));
        backButton = new JButton(back);
        backButton.setBounds(10, 10, 52, 60);
        backButton.setBorder(new LineBorder(Colour.LIGHT_BG));
        backButton.addActionListener(presenter);
        backButton.setActionCommand("backLogIn");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backgroundP.add(backButton);

        search = new ImageIcon( FileManager.getValue("urlSearch"));
        searchButton = new JButton(search);
        searchButton.setBounds(930, 140, 381, 408);
        searchButton.addActionListener(presenter);
        searchButton.setActionCommand("search");
        backgroundP.add(searchButton);

        exclusive = new ImageIcon( FileManager.getValue("urlExclusive"));
        exclusiveButton = new JButton(exclusive);
        exclusiveButton.setBounds(850, 570, 544, 120);
        exclusiveButton.addActionListener(presenter);
        exclusiveButton.setActionCommand("exclusive");
        backgroundP.add(exclusiveButton);

        this.add(backgroundP);
    }
}
