package view;

import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import presenter.FileManager;

/**
 * SearchSection class extends BigFrames
 * This frame is for looking up for a book by the author or their tittle putting that information in a textField
 * and showing the result in a table.
 * @author Juan
 * @version 29/05/2024
 */

public class SearchSection extends BigFrames{

    private JPanel backgroundP;
    private Icon back;
    private JButton backButton;
    private TextField busqueda;
    private TextPrompt forBusqueda;
    private JPanel table;
    private JTableHeader header;
    private JTable lista;
    private JScrollPane scrollPane;

    /**
     * SearchSection constructor
     * 
     * @param presenter
     */

    public SearchSection(ActionListener presenter){

        this.setTitle("Shelter Pages - Search");

        backgroundP = new JPanel();
        backgroundP.setSize(750, 590);
        backgroundP.setLayout(null);
        backgroundP.setBackground(Colour.DARK_BG);

        back = new ImageIcon(FileManager.getValue("urlBack"));
        backButton= new JButton(back);
        backButton.setBorder(new LineBorder(Colour.DARK_BG));
        backButton.setBounds(10, 10, 51, 55);
        backButton.addActionListener(presenter);
        backButton.setActionCommand("backFromSearch");
        backgroundP.add(backButton);

        busqueda = new TextField();
        forBusqueda = new TextPrompt("Buscar libro por título, autor...", busqueda);
        forBusqueda.changeAlpha(0.5f);
        busqueda.setBounds(80, 80, 1300, 100);
        backgroundP.add(busqueda);

        table = new JPanel();
        table.setLayout(null);
        table.setBounds(100, 90, 600, 650);
        table.setBackground(Colour.LIGHT_BG);

        table.setLayout(null);
        table.setBounds(100, 90, 600, 650);
        table.setBackground(Colour.LIGHT_BG); 
        
        Button search = new Button();
        search.setText("Buscar");
        search.setActionCommand("searchBooks");
        search.setBounds(1400, 80, 100, 100);
        search.addActionListener(presenter);
        backgroundP.add(search);

        this.add(backgroundP);
    }

    public void showBooks(Object[][] books) {
        if (scrollPane != null) {
            table.remove(scrollPane); 
        }
        Object[] columnNames = {"Titulo", "Autor", "Precio"};    
        lista = new JTable(books, columnNames);
        lista.setEnabled(false);
        lista.setRowHeight(50);
        header = lista.getTableHeader();
        header.setBackground(Colour.CHOCO);
        header.setForeground(Colour.CREAM); 
        scrollPane = new JScrollPane(lista);
        scrollPane.setBounds(0, 0, 1450, 500);
        table.add(scrollPane);
        table.setBounds(80, 200, 1423, 500);
        backgroundP.add(table);
    }

    public TextField getBusqueda() {
        return busqueda;
    }

    
}
