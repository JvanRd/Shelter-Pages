package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presenter.FileManager;

/**
 * ArtSection class extends SectionBase
 * This frame shows all the books from the Art section, with JLabels to show
 * their tittles, authors, prices and buttos to add to the basket.
 * @author Juan
 * @version 29/05/2024
 */

public class ArtSection extends SectionBase{

    private JLabel sectionName;
    private ImageIcon monet;
    private JLabel monetL;
    private JLabel monetTitle;
    private JLabel monetPrice;
    private Button monetButton;
    private JLabel monetAuthor;
    private ImageIcon muerteBarroca;
    private JLabel barrocaL;
    private JLabel barrocaTitle;
    private JLabel barrocaAuthor;
    private JLabel barrocaPrice;
    private Button barrocaButton;
    private ImageIcon paraisoPinceladas;
    private JLabel paraisoL;
    private JLabel paraisoTitle;
    private JLabel paraisoAuthor;
    private JLabel paraisoPrice;
    private Button paraisoButton;
    private ImageIcon historiaFealdad;
    private JLabel fealdadL;
    private JLabel fealdadTitle;
    private JLabel fealdadAuthor;
    private JLabel fealdadPrice;
    private Button fealdadButton;
    
    /**
     * Constructor for ArtSection
     * @param presenter
     */
    public ArtSection(ActionListener presenter) {
        super(presenter);
        setTitle("Shelter Pages - Art");

        sectionName = new JLabel("ARTE!!!");
        sectionName.setBounds(630, 10, 500, 100);
        sectionName.setForeground(Colour.CHOCO);
        sectionName.setFont(getBogart());
        getBooksPanel().add(sectionName);

        monet = new ImageIcon( FileManager.getValue("urlMonet"));
        monetL = new JLabel(monet);
        monetL.setBounds(110,100,260,400);

        monetTitle = new JLabel("Monet");
        monetTitle.setBounds(110, 470, 500, 100);
        monetTitle.setFont(getHappy());
        monetTitle.setForeground(Colour.CHOCO);

        monetAuthor = new JLabel("Daniel Wildenstein");
        monetAuthor.setBounds(110, 495, 500, 100);
        monetAuthor.setFont(getHappy());
        monetAuthor.setForeground(Colour.CHOCO);

        monetPrice = new JLabel("$ 39.000");
        monetPrice.setBounds(110, 515, 500, 100);
        monetPrice.setForeground(Colour.CHOCO);
        monetPrice.setFont(getAston());

        monetButton = new Button();
        monetButton.setText("Agregar");
        monetButton.setActionCommand("addMonet");
        monetButton.addActionListener(presenter);
        monetButton.setBounds(170, 580, 150, 40);

        getBooksPanel().add(monetL);
        getBooksPanel().add(monetTitle);
        getBooksPanel().add(monetAuthor);
        getBooksPanel().add(monetPrice);
        getBooksPanel().add(monetButton);

        muerteBarroca = new ImageIcon( FileManager.getValue("urlMuerteBarroca"));
        barrocaL = new JLabel(muerteBarroca);
        barrocaL.setBounds(410, 100, 260, 400);

        barrocaTitle = new JLabel("Muerte Barroca");
        barrocaTitle.setBounds(410, 470, 500, 100);
        barrocaTitle.setFont(getHappy());
        barrocaTitle.setForeground(Colour.CHOCO);

        barrocaAuthor = new JLabel("Banco Rep.");
        barrocaAuthor.setBounds(410, 495, 500, 100);
        barrocaAuthor.setFont(getHappy());
        barrocaAuthor.setForeground(Colour.CHOCO);

        barrocaPrice = new JLabel("$ 25.000");
        barrocaPrice.setBounds(410, 515, 500, 100);
        barrocaPrice.setForeground(Colour.CHOCO);
        barrocaPrice.setFont(getAston());

        barrocaButton = new Button();
        barrocaButton.setText("Agregar");
        barrocaButton.addActionListener(presenter);
        barrocaButton.setActionCommand("addBarroca");
        barrocaButton.setBounds(470, 580, 150, 40);

        getBooksPanel().add(barrocaL);
        getBooksPanel().add(barrocaTitle);
        getBooksPanel().add(barrocaAuthor);
        getBooksPanel().add(barrocaPrice);
        getBooksPanel().add(barrocaButton);

        paraisoPinceladas = new ImageIcon( FileManager.getValue("urlPinceladas"));
        paraisoL = new JLabel(paraisoPinceladas);
        paraisoL.setBounds(710, 100, 260, 400);

        paraisoTitle = new JLabel("El paraíso a pinceladas");
        paraisoTitle.setBounds(710, 470, 500, 100);
        paraisoTitle.setFont(getHappy());
        paraisoTitle.setForeground(Colour.CHOCO);

        paraisoAuthor = new JLabel("Eduardo Barba Gomez");
        paraisoAuthor.setBounds(710, 495, 500, 100);
        paraisoAuthor.setFont(getHappy());
        paraisoAuthor.setForeground(Colour.CHOCO);

        paraisoPrice = new JLabel("$ 67.000");
        paraisoPrice.setBounds(710, 515, 500, 100);
        paraisoPrice.setForeground(Colour.CHOCO);
        paraisoPrice.setFont(getAston());

        paraisoButton = new Button();
        paraisoButton.setText("Agregar");
        paraisoButton.addActionListener(presenter);
        paraisoButton.setActionCommand("addParaiso");
        paraisoButton.setBounds(770, 580, 150, 40);

        getBooksPanel().add(paraisoL);
        getBooksPanel().add(paraisoTitle);
        getBooksPanel().add(paraisoAuthor);
        getBooksPanel().add(paraisoPrice);
        getBooksPanel().add(paraisoButton);

        historiaFealdad = new ImageIcon( FileManager.getValue("urlFealdad"));
        fealdadL = new JLabel(historiaFealdad);
        fealdadL.setBounds(1010, 100, 260, 400);

        fealdadTitle = new JLabel("Historia de la Fealdad");
        fealdadTitle.setBounds(1010, 470, 500, 100);
        fealdadTitle.setFont(getHappy());
        fealdadTitle.setForeground(Colour.CHOCO);

        fealdadAuthor = new JLabel("Umberto Eco");
        fealdadAuthor.setBounds(1010, 495, 500, 100);
        fealdadAuthor.setFont(getHappy());
        fealdadAuthor.setForeground(Colour.CHOCO);

        fealdadPrice = new JLabel("$ 120.000");
        fealdadPrice.setBounds(1010, 515, 500, 100);
        fealdadPrice.setForeground(Colour.CHOCO);
        fealdadPrice.setFont(getAston());

        fealdadButton = new Button();
        fealdadButton.setText("Agregar");
        fealdadButton.addActionListener(presenter);
        fealdadButton.setActionCommand("addFealdad");
        fealdadButton.setBounds(1070, 580, 150, 40);

        getBooksPanel().add(fealdadL);
        getBooksPanel().add(fealdadTitle);
        getBooksPanel().add(fealdadAuthor);
        getBooksPanel().add(fealdadPrice);
        getBooksPanel().add(fealdadButton);
    }
}
