package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presenter.FileManager;

/**
 * FantasySection class extends SectionBase
 * This frame shows all the books from the Fantasy section, with JLabels to show
 * their tittles, authors, prices and buttos to add to the basket.
 * @author Juan
 * @version 29/05/2024
 */

public class FantasySection extends SectionBase{

    private JLabel sectionName;
    private ImageIcon alicia;
    private JLabel aliciaL;
    private JLabel aliciaTitle;
    private Button aliciaButton;
    private JLabel aliciaAuthor;
    private JLabel aliciaPrice;
    private ImageIcon cazadores;
    private JLabel cazadoresL;
    private JLabel cazadoresTitle;
    private JLabel cazadoresAuthor;
    private JLabel cazadoresPrice;
    private Button cazadoresButton;
    private ImageIcon narnia;
    private JLabel narniaL;
    private JLabel narniaTitle;
    private JLabel narniaAuthor;
    private JLabel narniaPrice;
    private Button narniaButton;
    private ImageIcon reinaRoja;
    private JLabel reinaL;
    private JLabel reinaTitle;
    private JLabel reinaAuthor;
    private JLabel reinaPrice;
    private Button reinaButton;

    /**
     * Constructor for the FantasySection.
     * @param presenter
     */

    public FantasySection(ActionListener presenter) {
        super(presenter);
        setTitle("Shelter Pages - Fantasy");

        sectionName = new JLabel("FANTASIA");
        sectionName.setBounds(590, 10, 500, 100);
        sectionName.setForeground(Colour.CHOCO);
        sectionName.setFont(getBogart());
        getBooksPanel().add(sectionName);

        alicia = new ImageIcon( FileManager.getValue("urlAlicia"));
        aliciaL = new JLabel(alicia);
        aliciaL.setBounds(110,100,260,400);

        aliciaTitle = new JLabel("Alice in Wonderland");
        aliciaTitle.setBounds(110, 470, 500, 100);
        aliciaTitle.setFont(getHappy());
        aliciaTitle.setForeground(Colour.CHOCO);

        aliciaAuthor = new JLabel("Lewis Carroll");
        aliciaAuthor.setBounds(110, 495, 500, 100);
        aliciaAuthor.setFont(getHappy());
        aliciaAuthor.setForeground(Colour.CHOCO);

        aliciaPrice = new JLabel("$ 50.100");
        aliciaPrice.setBounds(110, 515, 500, 100);
        aliciaPrice.setForeground(Colour.CHOCO);
        aliciaPrice.setFont(getAston());

        aliciaButton = new Button();
        aliciaButton.setText("Agregar");
        aliciaButton.addActionListener(presenter);
        aliciaButton.setActionCommand("addAlicia");
        aliciaButton.setBounds(170, 580, 150, 40);

        getBooksPanel().add(aliciaL);
        getBooksPanel().add(aliciaTitle);
        getBooksPanel().add(aliciaAuthor);
        getBooksPanel().add(aliciaPrice);
        getBooksPanel().add(aliciaButton);

        cazadores = new ImageIcon( FileManager.getValue("urlCazadores"));
        cazadoresL = new JLabel(cazadores);
        cazadoresL.setBounds(410, 100, 260, 400);

        cazadoresTitle = new JLabel("Cazadores de Sombras");
        cazadoresTitle.setBounds(410, 470, 500, 100);
        cazadoresTitle.setFont(getHappy());
        cazadoresTitle.setForeground(Colour.CHOCO);

        cazadoresAuthor = new JLabel("Cassandra Clare");
        cazadoresAuthor.setBounds(410, 495, 500, 100);
        cazadoresAuthor.setFont(getHappy());
        cazadoresAuthor.setForeground(Colour.CHOCO);

        cazadoresPrice = new JLabel("$ 68.000");
        cazadoresPrice.setBounds(410, 515, 500, 100);
        cazadoresPrice.setForeground(Colour.CHOCO);
        cazadoresPrice.setFont(getAston());

        cazadoresButton = new Button();
        cazadoresButton.setText("Agregar");
        cazadoresButton.addActionListener(presenter);
        cazadoresButton.setActionCommand("addCazadores");
        cazadoresButton.setBounds(470, 580, 150, 40);

        getBooksPanel().add(cazadoresL);
        getBooksPanel().add(cazadoresTitle);
        getBooksPanel().add(cazadoresAuthor);
        getBooksPanel().add(cazadoresPrice);
        getBooksPanel().add(cazadoresButton);

        narnia = new ImageIcon( FileManager.getValue("urlNarnia"));
        narniaL = new JLabel(narnia);
        narniaL.setBounds(710, 100, 260, 400);

        narniaTitle = new JLabel("Narnia");
        narniaTitle.setBounds(710, 470, 500, 100);
        narniaTitle.setFont(getHappy());
        narniaTitle.setForeground(Colour.CHOCO);

        narniaAuthor = new JLabel("C. S. Lewis");
        narniaAuthor.setBounds(710, 495, 500, 100);
        narniaAuthor.setFont(getHappy());
        narniaAuthor.setForeground(Colour.CHOCO);

        narniaPrice = new JLabel("$ 60.000");
        narniaPrice.setBounds(710, 515, 500, 100);
        narniaPrice.setForeground(Colour.CHOCO);
        narniaPrice.setFont(getAston());

        narniaButton = new Button();
        narniaButton.setText("Agregar");
        narniaButton.addActionListener(presenter);
        narniaButton.setActionCommand("addNarnia");
        narniaButton.setBounds(770, 580, 150, 40);

        getBooksPanel().add(narniaL);
        getBooksPanel().add(narniaTitle);
        getBooksPanel().add(narniaAuthor);
        getBooksPanel().add(narniaPrice);
        getBooksPanel().add(narniaButton);

        reinaRoja = new ImageIcon( FileManager.getValue("urlReinaR"));
        reinaL = new JLabel(reinaRoja);
        reinaL.setBounds(1010, 100, 260, 400);

        reinaTitle = new JLabel("La Reina Roja");
        reinaTitle.setBounds(1010, 470, 500, 100);
        reinaTitle.setFont(getHappy());
        reinaTitle.setForeground(Colour.CHOCO);

        reinaAuthor = new JLabel("Victoria Aveyard");
        reinaAuthor.setBounds(1010, 495, 500, 100);
        reinaAuthor.setFont(getHappy());
        reinaAuthor.setForeground(Colour.CHOCO);

        reinaPrice = new JLabel("$ 30.000");
        reinaPrice.setBounds(1010, 515, 500, 100);
        reinaPrice.setForeground(Colour.CHOCO);
        reinaPrice.setFont(getAston());

        reinaButton = new Button();
        reinaButton.setText("Agregar");
        reinaButton.addActionListener(presenter);
        reinaButton.setActionCommand("addReina");
        reinaButton.setBounds(1070, 580, 150, 40);

        getBooksPanel().add(reinaL);
        getBooksPanel().add(reinaTitle);
        getBooksPanel().add(reinaAuthor);
        getBooksPanel().add(reinaPrice);
        getBooksPanel().add(reinaButton);
    }
}
