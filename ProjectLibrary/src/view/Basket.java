package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import presenter.FileManager;

/**
 * Basket class extends BigFrames.
 * This frame includes a table for showing all the products form the basket, as well a panel for showing the user info and a button
 * for editing the basket books and the balance of the user itself.
 * @author Juan
 * @version 29/05/2024
 */

public class Basket extends BigFrames {

    private JPanel backgroundP;
    private Icon back;
    private JButton backButton;
    private JPanel table;
    private JTableHeader header;
    private JTable lista;
    private JScrollPane scrollPane;
    private JPanel user;
    private ImageIcon logo;
    private JLabel logoLabel;
    private JLabel nombre;
    private JLabel saldo;
    private Button editarSaldo;
    private Button shop;
    private Button delete;
    private Object[][] basket;
    private ArrayList<String> booksSelected;

    /**
     * Constructor for Basket.
     * @param presenter
     */

    public Basket(ActionListener presenter) {

        this.setTitle("Shelter Pages - Basket");

        booksSelected = new ArrayList<String>();

        backgroundP = new JPanel();
        backgroundP.setSize(750, 590);
        backgroundP.setLayout(null);
        backgroundP.setBackground(Colour.DARK_BG);

        back = new ImageIcon( FileManager.getValue("urlBack"));
        backButton = new JButton(back);
        backButton.setBorder(new LineBorder(Colour.DARK_BG));
        backButton.setBounds(10, 10, 51, 55);
        backButton.addActionListener(presenter);
        backButton.setActionCommand("backFromBasket");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backgroundP.add(backButton);

        table = new JPanel();
        table.setLayout(null);
        table.setBounds(100, 90, 600, 650);
        table.setBackground(Colour.LIGHT_BG);

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

        nombre = new JLabel("Nombre");
        nombre.setBounds(280, 230, 500, 100);
        nombre.setFont(getAston());
        user.add(nombre);

        saldo = new JLabel("Saldo: ");
        saldo.setBounds(260, 260, 500, 100);
        saldo.setFont(getAston());
        user.add(saldo);

        editarSaldo = new Button();
        editarSaldo.setText("Editar Saldo");
        editarSaldo.setBounds(180, 350, 250, 70);
        editarSaldo.addActionListener(presenter);
        editarSaldo.setActionCommand("showEditBalance");
        user.add(editarSaldo);

        shop = new Button();
        shop.setText("Comprar");
        shop.setActionCommand("buyBasket");
        shop.addActionListener(presenter);
        shop.setBounds(180, 450, 250, 70);
        user.add(shop);

        delete = new Button();
        delete.setText("Eliminar");
        delete.setActionCommand("deleteBasket");
        delete.addActionListener(presenter);
        delete.setBounds(180, 550, 250, 70);
        user.add(delete);

        deleteBooks();
        backgroundP.add(user);
        this.add(backgroundP);
    }

    private void deleteBooks() {
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public void showBasket(Object[][] basket) {
        this.basket = basket;
        if (scrollPane != null) {
            table.remove(scrollPane);
        }
        Object[] columnNames = { "Titulo", "Precio" };
        lista = new JTable(this.basket, columnNames);
        lista.setEnabled(false);
        header = lista.getTableHeader();
        header.setBackground(Colour.CHOCO);
        header.setForeground(Colour.CREAM);
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = lista.rowAtPoint(e.getPoint());
                if (lista.isRowSelected(row)) {
                    lista.removeRowSelectionInterval(row, row);
                    String title = lista.getValueAt(row, 0).toString();
                    booksSelected.remove(title);
                } else {
                    lista.addRowSelectionInterval(row, row);
                    String title = lista.getValueAt(row, 0).toString();
                    if (!booksSelected.contains(title)) {
                        booksSelected.add(title); 
                    }
                }
                lista.repaint();
            }
        });
    
        lista.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    cellComponent.setBackground(new Color(237, 36, 64));
                } else {
                    cellComponent.setBackground(Color.WHITE);
                }
                return cellComponent;
            }
        });
    

        scrollPane = new JScrollPane(lista);
        scrollPane.setBounds(0, 0, 600, 650);
        table.add(scrollPane);
        backgroundP.add(table);
    }

    public void showInfo(String nameUser, String money) {
        if (!nameUser.isBlank()) {
            nombre.setText("Hola: " + nameUser);
        }
        saldo.setText("Saldo: " + money);
    }

    public ArrayList<String> getBooksSelected() {
        return booksSelected;
    }

    
}