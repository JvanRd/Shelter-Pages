package view;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import presenter.FileManager;

/**
 * Exclusive class extends BigFrames
 * This frame shows all the exclusive books from the library, with JLabels to show
 * their tittles, authors, prices and buttons to add to the basket.
 * @author Juan
 * @version 29/05/2024
 */

public class Exclusive extends BigFrames{

    private JPanel backgroundP;
    private Icon back;
    private JButton backButton;
    private ImageIcon maleducada;
    private JLabel maleducadaL;
    private JLabel maleducadaTittle;
    private JLabel maleducadaAuthor;
    private JLabel maleducadaPrice;
    private Button maleducadaButton;
    private ImageIcon blindes;
    private JLabel blindesL;
    private JLabel blindesTittle;
    private JLabel blindesAuthor;
    private JLabel blindesPrice;
    private Button blindesButton;
    private ImageIcon boulevard;
    private JLabel boulevardL;
    private JLabel boulevardTittle;
    private JLabel boulevardAuthor;
    private JLabel boulevardPrice;
    private Button boulevardButton;
    private JLabel sectionName;
    
    /**
     * Constructor for the Exclusive frame.
     * @param presenter
     */
    public Exclusive(ActionListener presenter){
        setTitle("Shelter Pages - Exclusive Books");
        backgroundP = new JPanel();
        maleducadaButton = new Button();
        blindesButton = new Button();
        boulevardButton = new Button();

        backgroundP.setSize(750, 590);
        backgroundP.setLayout(null);
        backgroundP.setBackground(Colour.DARK_BG);

        back = new ImageIcon(FileManager.getValue("urlBack"));
        backButton= new JButton(back);
        backButton.setBorder(new LineBorder(Colour.DARK_BG));
        backButton.setBounds(10, 10, 51, 55);
        backButton.addActionListener(presenter);
        backButton.setActionCommand("backFromExclusive");
        backgroundP.add(backButton);

        sectionName = new JLabel("LIBROS IMPORTADOS");
        sectionName.setBounds(350, 50, 1000, 100);
        sectionName.setForeground(Colour.CHOCO);
        sectionName.setFont(getBogart());
        backgroundP.add(sectionName);

        maleducada = new ImageIcon( FileManager.getValue("urlMaleducada"));
        maleducadaL = new JLabel(maleducada);
        maleducadaL.setBounds(310, 200, 260, 400);
        backgroundP.add(maleducadaL);

        maleducadaTittle = new JLabel("Maleducada");
        maleducadaTittle.setBounds(310, 570, 500, 100);
        maleducadaTittle.setFont(getHappy());
        maleducadaTittle.setForeground(Colour.CHOCO);
        backgroundP.add(maleducadaTittle);

        maleducadaAuthor = new JLabel("Antonio Ortiz");
        maleducadaAuthor.setBounds(310, 595, 500, 100);
        maleducadaAuthor.setForeground(Colour.CHOCO);
        maleducadaAuthor.setFont(getHappy());
        backgroundP.add(maleducadaAuthor);

        maleducadaPrice = new JLabel("$ 25.000");
        maleducadaPrice.setBounds(310, 620, 500, 100);
        maleducadaPrice.setForeground(Colour.CHOCO);
        maleducadaPrice.setFont(getAston());

        maleducadaButton.setText("Agregar");
        maleducadaButton.setBounds(370, 690, 150, 40);
        maleducadaButton.addActionListener(presenter);  
        maleducadaButton.setActionCommand("addMaleducada");
        backgroundP.add(maleducadaButton);
        backgroundP.add(maleducadaPrice);

        blindes = new ImageIcon(FileManager.getValue("urlBlindess"));
        blindesL = new JLabel(blindes);
        blindesL.setBounds(620, 200, 260, 400);
        backgroundP.add(blindesL);

        blindesTittle = new JLabel("Ensayo sobre la Ceguera");
        blindesTittle.setBounds(620, 570, 500, 100);
        blindesTittle.setFont(getHappy());
        blindesTittle.setForeground(Colour.CHOCO);
        backgroundP.add(blindesTittle);

        blindesAuthor = new JLabel("José Saramago");
        blindesAuthor.setBounds(620, 595, 500, 100);
        blindesAuthor.setForeground(Colour.CHOCO);
        blindesAuthor.setFont(getHappy());
        backgroundP.add(blindesAuthor);

        blindesPrice = new JLabel("$ 49.000");
        blindesPrice.setBounds(620, 620, 500, 100);
        blindesPrice.setForeground(Colour.CHOCO);
        blindesPrice.setFont(getAston());

        blindesButton.setText("Agregar");
        blindesButton.setBounds(680, 690, 150, 40);
        blindesButton.addActionListener(presenter);
        blindesButton.setActionCommand("addBlindes");
        backgroundP.add(blindesButton);
        backgroundP.add(blindesPrice);

        boulevard = new ImageIcon(FileManager.getValue("urlBoulevard"));
        boulevardL = new JLabel(boulevard);
        boulevardL.setBounds(930, 200, 260, 400);
        backgroundP.add(boulevardL);

        boulevardTittle = new JLabel("Boulevard");
        boulevardTittle.setBounds(930, 570, 500, 100);
        boulevardTittle.setFont(getHappy());
        boulevardTittle.setForeground(Colour.CHOCO);
        backgroundP.add(boulevardTittle);

        boulevardAuthor = new JLabel("Flor M. Salvador");
        boulevardAuthor.setBounds(930, 595, 500, 100);
        boulevardAuthor.setForeground(Colour.CHOCO);
        boulevardAuthor.setFont(getHappy());
        backgroundP.add(boulevardAuthor);

        boulevardPrice = new JLabel("$ 50.000");
        boulevardPrice.setBounds(930, 620, 500, 100);
        boulevardPrice.setForeground(Colour.CHOCO);
        boulevardPrice.setFont(getAston());

        boulevardButton.setText("Agregar");
        boulevardButton.setBounds(990, 690, 150, 40);
        boulevardButton.addActionListener(presenter);
        boulevardButton.setActionCommand("addBoulevard");
        backgroundP.add(boulevardButton);
        backgroundP.add(boulevardPrice);

        this.add(backgroundP);
    }
}
