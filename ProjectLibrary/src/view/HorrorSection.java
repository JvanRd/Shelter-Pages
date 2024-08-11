package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presenter.FileManager;

/**
 * HorrorSection class extends SectionBase
 * This frame shows all the books from the Horror section, with JLabels to show
 * their tittles, authors, prices and buttos to add to the basket.
 * @author Juan
 * @version 29/05/2024
 */

public class HorrorSection extends SectionBase{

    private JLabel sectionName;
    private ImageIcon chicaGris;
    private JLabel CGL;
    private JLabel CGTitle;
    private Button chicaButton;
    private JLabel CGAuthor;
    private JLabel CGPrice;
    private ImageIcon Bazar;
    private JLabel BazarL;
    private JLabel BazazTitle;
    private JLabel BazarAuthor;
    private JLabel bazarPrice;
    private Button bazarButton;
    private ImageIcon gatoNegro;
    private JLabel gatoNegroL;
    private JLabel gatoNegroTitle;
    private JLabel gatoNegroAuthor;
    private JLabel gatoNegroPrice;
    private Button gatoNegroButton;
    private ImageIcon ladymasacre;
    private JLabel ladyL;
    private JLabel ladyTitle;
    private JLabel ladyAuthor;
    private JLabel ladyPrice;
    private Button ladyButton;

    /**
     * Constructor for HorrorSection
     * 
     * @param presenter
     */

    public HorrorSection(ActionListener presenter) {
        super(presenter);
        setTitle("Shelter Pages - Horror");

        sectionName = new JLabel("TERROR");
        sectionName.setBounds(612, 10, 500, 100);
        sectionName.setForeground(Colour.CHOCO);
        sectionName.setFont(getBogart());
        getBooksPanel().add(sectionName);

        chicaGris = new ImageIcon( FileManager.getValue("urlChicagris"));
        CGL = new JLabel(chicaGris);
        CGL.setBounds(110,100,260,400);

        CGTitle = new JLabel("La Chica Gris");
        CGTitle.setBounds(110, 470, 500, 100);
        CGTitle.setFont(getHappy());
        CGTitle.setForeground(Colour.CHOCO);

        CGAuthor = new JLabel("Antonio Runa");
        CGAuthor.setBounds(110, 495, 500, 100);
        CGAuthor.setFont(getHappy());
        CGAuthor.setForeground(Colour.CHOCO);

        CGPrice = new JLabel("$ 55.000");
        CGPrice.setBounds(110, 515, 500, 100);
        CGPrice.setForeground(Colour.CHOCO);
        CGPrice.setFont(getAston());

        chicaButton = new Button();
        chicaButton.setText("Agregar");
        chicaButton.addActionListener(presenter);
        chicaButton.setActionCommand("addChica");
        chicaButton.setBounds(170, 580, 150, 40);

        getBooksPanel().add(CGPrice);
        getBooksPanel().add(chicaButton);
        getBooksPanel().add(CGAuthor);
        getBooksPanel().add(CGTitle);
        getBooksPanel().add(CGL);

        Bazar = new ImageIcon( FileManager.getValue("urlBazar"));
        BazarL = new JLabel(Bazar);
        BazarL.setBounds(410, 100, 260, 400);

        BazazTitle = new JLabel("El Bazar de los malos sueños");
        BazazTitle.setBounds(410, 470, 500, 100);
        BazazTitle.setFont(getHappy());
        BazazTitle.setForeground(Colour.CHOCO);

        BazarAuthor = new JLabel("Stephen King");
        BazarAuthor.setBounds(410, 495, 500, 100);
        BazarAuthor.setFont(getHappy());
        BazarAuthor.setForeground(Colour.CHOCO);

        bazarPrice = new JLabel("$ 65.000");
        bazarPrice.setBounds(410, 515, 500, 100);
        bazarPrice.setForeground(Colour.CHOCO);
        bazarPrice.setFont(getAston());

        bazarButton = new Button();
        bazarButton.setText("Agregar");
        bazarButton.addActionListener(presenter);
        bazarButton.setActionCommand("addBazar");
        bazarButton.setBounds(470, 580, 150, 40);

        getBooksPanel().add(bazarPrice);
        getBooksPanel().add(bazarButton);
        getBooksPanel().add(BazarAuthor);
        getBooksPanel().add(BazazTitle);
        getBooksPanel().add(BazarL);

        gatoNegro = new ImageIcon( FileManager.getValue("urlCuentosTerror"));
        gatoNegroL = new JLabel(gatoNegro);
        gatoNegroL.setBounds(710, 100, 260, 400);

        gatoNegroTitle = new JLabel("El Gato Negro");
        gatoNegroTitle.setBounds(710, 470, 500, 100);
        gatoNegroTitle.setFont(getHappy());
        gatoNegroTitle.setForeground(Colour.CHOCO);

        gatoNegroAuthor = new JLabel("Edgar Allan Poe");
        gatoNegroAuthor.setBounds(710, 495, 500, 100);
        gatoNegroAuthor.setFont(getHappy());
        gatoNegroAuthor.setForeground(Colour.CHOCO);

        gatoNegroPrice = new JLabel("$ 60.000");
        gatoNegroPrice.setBounds(710, 515, 500, 100);
        gatoNegroPrice.setForeground(Colour.CHOCO);
        gatoNegroPrice.setFont(getAston());

        gatoNegroButton = new Button();
        gatoNegroButton.setText("Agregar");
        gatoNegroButton.addActionListener(presenter);
        gatoNegroButton.setActionCommand("addGato");
        gatoNegroButton.setBounds(770, 580, 150, 40);

        getBooksPanel().add(gatoNegroPrice);
        getBooksPanel().add(gatoNegroButton);
        getBooksPanel().add(gatoNegroAuthor);
        getBooksPanel().add(gatoNegroTitle);
        getBooksPanel().add(gatoNegroL);
        
        ladymasacre = new ImageIcon( FileManager.getValue("urlLadyMasacre"));
        ladyL = new JLabel(ladymasacre);
        ladyL.setBounds(1010, 100, 260, 400);

        ladyTitle = new JLabel("Lady Masacre");
        ladyTitle.setBounds(1010, 470, 500, 100);
        ladyTitle.setFont(getHappy());
        ladyTitle.setForeground(Colour.CHOCO);

        ladyAuthor = new JLabel("Mario Mendoza");
        ladyAuthor.setBounds(1010, 495, 500, 100);
        ladyAuthor.setFont(getHappy());
        ladyAuthor.setForeground(Colour.CHOCO);

        ladyPrice = new JLabel("$ 30.000");
        ladyPrice.setBounds(1010, 515, 500, 100);
        ladyPrice.setForeground(Colour.CHOCO);
        ladyPrice.setFont(getAston());

        ladyButton = new Button();
        ladyButton.setText("Agregar");
        ladyButton.addActionListener(presenter);
        ladyButton.setActionCommand("addLady");
        ladyButton.setBounds(1070, 580, 150, 40);

        getBooksPanel().add(ladyPrice);
        getBooksPanel().add(ladyButton);
        getBooksPanel().add(ladyAuthor);
        getBooksPanel().add(ladyTitle);
        getBooksPanel().add(ladyL);
    }
}
