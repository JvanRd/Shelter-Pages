package view;

import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * LogInFrame class extends InfoFrame
 * This frame is used for the user login.
 * Uses a TextField for the user name and a PasswordField for the password.
 * Uses a Button for login and a Button for creating an account.
 * @author Juan
 * @version 29/05/2024
 */

public class LogInFrame extends InfoFrame{
    
    private JPanel backgroundP;
    private TextField tfu;
    private TextPrompt forTFU;
    private PasswordField tfp;
    private TextPrompt forTFP;
    private ImageIcon logo;
    private JLabel logoLabel;
    private Button iniciarS;
    private Button crearC;

    public LogInFrame(ActionListener presenter){
        backgroundP = new JPanel();
        tfu = new TextField();
        tfp = new PasswordField();
        iniciarS = new Button();
        crearC = new Button();

        this.setTitle("Shelter Pages - Log In");
        backgroundP.setSize(750, 590);
        backgroundP.setLayout(null);
        backgroundP.setBackground(Colour.LIGHT_BG);

        logo = new ImageIcon("resources/images/logo.png");
        logoLabel = new JLabel(logo);
        logoLabel.setBounds(270, 40, 192, 223);
        backgroundP.add(logoLabel);
        forTFU = new TextPrompt("Ingresa tu usuario", tfu);
        forTFU.changeAlpha(0.5f);
        tfu.setBounds(216, 290, 300, 40);
        forTFP = new TextPrompt("Ingresa tu contraseña", tfp);
        forTFP.changeAlpha(0.5f);
        tfp.setBounds(216, 350, 300, 40);
        backgroundP.add(tfu);
        backgroundP.add(tfp);

        iniciarS.setText("Iniciar Sesión");
        iniciarS.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iniciarS.setBounds(295, 400, 150, 40);
        iniciarS.addActionListener(presenter);
        iniciarS.setActionCommand("ingresar");
        crearC.setText("Crear Cuenta");
        crearC.setBounds(295, 450, 150, 40);
        crearC.addActionListener(presenter);
        crearC.setActionCommand("crearL");
        crearC.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backgroundP.add(iniciarS);
        backgroundP.add(crearC);
        this.add(backgroundP);
    }

    /**
     * Returns the TextField object associated with the variable tfu.
     *
     * @return  the TextField object tfu
     */
    public TextField getTfu() {
        return tfu;
    }

    /**
     * Sets the TextField object for the tfu variable.
     *
     * @param  tfu  the TextField object to be set
     */
    public void setTfu(TextField tfu) {
        this.tfu = tfu;
    }

    /**
     * Retrieves the TextField object representing the password input field.
     *
     * @return the TextField object representing the password input field
     */
    public PasswordField getTfp() {
        return tfp;
    }

    /**
     * Sets the value of the tfp field to the given TextField object.
     *
     * @param  tfp  the TextField object to set the tfp field to
     */
    public void setTfp(PasswordField tfp) {
        this.tfp = tfp;
    }

    
}
