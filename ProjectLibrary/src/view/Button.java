package view;

import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * Button class extends JButton.
 * This Button class sets the asset for buttons for the proyect, like color, foreground, border and cursor
 * @author Juan
 * @version 29/05/2024
 */

public class Button extends JButton{
    
    public Button(){
        this.setBackground(Colour.CHOCO);
        this.setForeground(Colour.CREAM);
        this.setBorder(new LineBorder(Colour.BORDER));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}