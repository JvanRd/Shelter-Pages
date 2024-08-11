package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presenter.FileManager;

/**
 * RomanceSection class extends SectionBase
 * This frame shows all the books from the Romance section, with JLabels to show
 * their tittles, authors, prices and buttos to add to the basket.
 * @author Juan
 * @version 29/05/2024
 */

public class RomanceSection extends SectionBase{
    
    private JLabel sectionName;
    private ImageIcon orgulloYPrejuicio;
    private JLabel orgulloL;
    private JLabel orgulloTitle;
    private Button orgulloButton;
    private JLabel orgulloAuthor;
    private JLabel orgulloPrice;
    private ImageIcon heartstopper;
    private JLabel heartstopperL;
    private JLabel heartstopperTitle;
    private JLabel heartstopperAuthor;
    private JLabel heartstopperPrice;
    private Button heartstopperButton;
    private ImageIcon esteInvierno;
    private JLabel inviernoL;
    private JLabel inviernoTitle;
    private JLabel inviernoAuthor;
    private JLabel inviernoPrice;
    private Button inviernoButton;
    private ImageIcon dashylily;
    private JLabel dylL;
    private JLabel dylTitle;
    private JLabel dylAuthor;
    private JLabel dylPrice;
    private Button dylButton;

    /**
     * Constructor for RomanceSection
     * @param presenter
     */
    public RomanceSection(ActionListener presenter) {
        super(presenter);
        setTitle("Shelter Pages - Romance");

        sectionName = new JLabel("ROMANCE");
        sectionName.setBounds(580, 10, 500, 100);
        sectionName.setForeground(Colour.CHOCO);
        sectionName.setFont(getBogart());
        getBooksPanel().add(sectionName);

        orgulloYPrejuicio = new ImageIcon( FileManager.getValue("urlOyp"));
        orgulloL = new JLabel(orgulloYPrejuicio);
        orgulloL.setBounds(110,100,260,400);

        orgulloTitle = new JLabel("Orgullo Y Prejuicio");
        orgulloTitle.setBounds(110, 470, 500, 100);
        orgulloTitle.setFont(getHappy());
        orgulloTitle.setForeground(Colour.CHOCO);

        orgulloAuthor = new JLabel("Jane Austen");
        orgulloAuthor.setBounds(110, 495, 500, 100);
        orgulloAuthor.setFont(getHappy());
        orgulloAuthor.setForeground(Colour.CHOCO);

        orgulloPrice = new JLabel("$ 150.000");
        orgulloPrice.setBounds(110, 515, 500, 100);
        orgulloPrice.setForeground(Colour.CHOCO);
        orgulloPrice.setFont(getAston());

        orgulloButton = new Button();
        orgulloButton.setText("Agregar");
        orgulloButton.addActionListener(presenter);
        orgulloButton.setActionCommand("addOrgullo");
        orgulloButton.setBounds(170, 580, 150, 40);

        getBooksPanel().add(orgulloL);
        getBooksPanel().add(orgulloTitle);
        getBooksPanel().add(orgulloAuthor);
        getBooksPanel().add(orgulloPrice);
        getBooksPanel().add(orgulloButton);

        heartstopper = new ImageIcon( FileManager.getValue("urlHeartstopper"));
        heartstopperL = new JLabel(heartstopper);
        heartstopperL.setBounds(410, 100, 260, 400);

        heartstopperTitle = new JLabel("Heartstopper");
        heartstopperTitle.setBounds(410, 470, 500, 100);
        heartstopperTitle.setFont(getHappy());
        heartstopperTitle.setForeground(Colour.CHOCO);

        heartstopperAuthor = new JLabel("Alice Oseman");
        heartstopperAuthor.setBounds(410, 495, 500, 100);
        heartstopperAuthor.setFont(getHappy());
        heartstopperAuthor.setForeground(Colour.CHOCO);

        heartstopperPrice = new JLabel("$ 20.500");
        heartstopperPrice.setBounds(410, 515, 500, 100);
        heartstopperPrice.setForeground(Colour.CHOCO);
        heartstopperPrice.setFont(getAston());

        heartstopperButton = new Button();
        heartstopperButton.setText("Agregar");
        heartstopperButton.addActionListener(presenter);
        heartstopperButton.setActionCommand("addHeart");
        heartstopperButton.setBounds(470, 580, 150, 40);

        getBooksPanel().add(heartstopperL);
        getBooksPanel().add(heartstopperTitle);
        getBooksPanel().add(heartstopperAuthor);
        getBooksPanel().add(heartstopperPrice);
        getBooksPanel().add(heartstopperButton);

        esteInvierno = new ImageIcon( FileManager.getValue("urlEsteInvierno"));
        inviernoL = new JLabel(esteInvierno);
        inviernoL.setBounds(710, 100, 260, 400);

        inviernoTitle = new JLabel("Este Invierno");
        inviernoTitle.setBounds(710, 470, 500, 100);
        inviernoTitle.setFont(getHappy());
        inviernoTitle.setForeground(Colour.CHOCO);

        inviernoAuthor = new JLabel("Alice Oseman");
        inviernoAuthor.setBounds(710, 495, 500, 100);
        inviernoAuthor.setFont(getHappy());
        inviernoAuthor.setForeground(Colour.CHOCO);

        inviernoPrice = new JLabel("$ 60.000");
        inviernoPrice.setBounds(710, 515, 500, 100);
        inviernoPrice.setForeground(Colour.CHOCO);
        inviernoPrice.setFont(getAston());

        inviernoButton = new Button();
        inviernoButton.setText("Agregar");
        inviernoButton.addActionListener(presenter);
        inviernoButton.setActionCommand("addInvierno");
        inviernoButton.setBounds(770, 580, 150, 40);

        getBooksPanel().add(inviernoL);
        getBooksPanel().add(inviernoTitle);
        getBooksPanel().add(inviernoAuthor);
        getBooksPanel().add(inviernoPrice);
        getBooksPanel().add(inviernoButton);

        dashylily = new ImageIcon( FileManager.getValue("urlDashylily"));
        dylL = new JLabel(dashylily);
        dylL.setBounds(1010, 100, 260, 400);

        dylTitle = new JLabel("Dash & Lily");
        dylTitle.setBounds(1010, 470, 500, 100);
        dylTitle.setFont(getHappy());
        dylTitle.setForeground(Colour.CHOCO);

        dylAuthor = new JLabel("David Levithan");
        dylAuthor.setBounds(1010, 495, 500, 100);
        dylAuthor.setFont(getHappy());
        dylAuthor.setForeground(Colour.CHOCO);

        dylPrice = new JLabel("$ 30.000");
        dylPrice.setBounds(1010, 515, 500, 100);
        dylPrice.setForeground(Colour.CHOCO);
        dylPrice.setFont(getAston());

        dylButton = new Button();
        dylButton.setText("Agregar");
        dylButton.addActionListener(presenter);
        dylButton.setActionCommand("addDyl");
        dylButton.setBounds(1070, 580, 150, 40);

        getBooksPanel().add(dylL);
        getBooksPanel().add(dylTitle);
        getBooksPanel().add(dylAuthor);
        getBooksPanel().add(dylPrice);
        getBooksPanel().add(dylButton);
    }
    
}
