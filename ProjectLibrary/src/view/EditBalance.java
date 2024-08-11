package view;

import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import presenter.FileManager;

/**
 * EditBalance class extends BigFrames
 * This frame shows the user balance and allows to edit it
 * @author Juan
 * @version 29/05/2024
 */

public class EditBalance extends BigFrames {

    private JPanel backgroundP;
    private JPanel table;
    private JTableHeader header;
    private JTable lista;
    private Icon back;
    private JButton backButton;
    private JScrollPane scrollPane;
    private JPanel user;
    private JLabel nombre;
    private JLabel saldo;
    private ImageIcon logo;
    private JLabel logoLabel;
    private TextField editarSaldo;
    private TextPrompt forBalance;
    private Button accept;
    private Object[][] basket;

    /**
     * EditBalance constructor
     * @param presenter
     */

    public EditBalance(ActionListener presenter) {
        this.setTitle("Shelter Pages - Balance");
        backgroundP = new JPanel();
        backgroundP.setSize(750, 590);
        backgroundP.setLayout(null);
        backgroundP.setBackground(Colour.DARK_BG);

        back = new ImageIcon( FileManager.getValue("urlBack"));
        backButton= new JButton(back);
        backButton.setBorder(new LineBorder(Colour.DARK_BG));
        backButton.setBounds(10, 10, 51, 55);
        backButton.addActionListener(presenter);
        backButton.setActionCommand("backFromEditBalance");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backgroundP.add(backButton);

        table = new JPanel();
        table.setLayout(null);
        table.setBounds(100, 90, 600, 650);
        table.setBackground(Colour.LIGHT_BG);

        table = new JPanel();
        table.setLayout(null);
        table.setBounds(100, 90, 600, 650);
        table.setBackground(Colour.LIGHT_BG);

        user = new JPanel();
        user.setLayout(null);
        user.setBounds(810, 90, 600, 650);
        user.setBackground(Colour.LIGHT_BG);
        logo = new ImageIcon( FileManager.getValue("urlLogo"));

        logoLabel = new JLabel(logo);
        logoLabel.setBounds(210, 10, 192, 223);
        user.add(logoLabel);

        nombre = new JLabel("nombre");
        nombre.setBounds(280, 230, 500, 100);
        nombre.setFont(getAston());
        user.add(nombre);

        saldo = new JLabel("Saldo: ");
        saldo.setBounds(260, 260, 500, 100);
        saldo.setFont(getAston());
        user.add(saldo);

        editarSaldo = new TextField();
        forBalance = new TextPrompt("Ingresa el monto que vas a agregar", editarSaldo);
        forBalance.changeAlpha(0.5f);
        editarSaldo.setBounds(180, 450, 250, 80);
        user.add(editarSaldo);

        accept = new Button();
        accept.setText("Aceptar");
        accept.setBounds(180, 550, 250, 80);
        accept.setActionCommand("acceptBalance");
        accept.addActionListener(presenter);
        user.add(accept);

        backgroundP.add(table);
        backgroundP.add(user);

        this.add(backgroundP);
    }

    /**
     * setInfo sets the info of EditBalance frame.
     * @param basket
     * @param name
     * @param money
     */
    public void setInfo(Object[][] basket, String name, String money) {
        this.basket = basket;
        if (scrollPane != null) {
            table.remove(scrollPane); 
        }
        Object[] columnNames = {"Titulo", "Precio"};
        lista = new JTable(this.basket, columnNames);
        lista.setEnabled(false);
        header = lista.getTableHeader();
        header.setBackground(Colour.CHOCO);
        header.setForeground(Colour.CREAM); 
        scrollPane = new JScrollPane(lista);
        scrollPane.setBounds(0, 0, 600, 650);
        table.add(scrollPane);
        backgroundP.add(table);

        nombre.setText(name);
        saldo.setText("Saldo: " + money);
    }

    /**
     * getBasket returns the basket
     * @return
     */
    public Object[][] getBasket(){
        return basket;
    }

    /**
     * getEditarSaldo returns the TextField
     * @return editarSaldo
     */
    public TextField getEditarSaldo() {
        return editarSaldo;
    }

    /**
     * restore restores the TextField
     */
    public void restore() {
        editarSaldo.setText("");
    }

    
    
}
