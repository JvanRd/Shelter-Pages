package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presenter.FileManager;

/**
 * SingInFrame class extends InfoFrame
 * This frame is used for the user sing up.
 * Uses a TextField for the user name and a PasswordField for the password.
 * Uses a Button for creating an account.
 * @author Juan
 * @version 29/05/2024
 */

public class SingInFrame extends InfoFrame{

    private JPanel backgroundP;
    private TextField tfu;
    private TextPrompt forTFU;
    private TextField tfp;
    private TextPrompt forTFP;
    private TextField tfm;
    private TextPrompt forTFM;
    private ImageIcon logo;
    private JLabel logoLabel;
    private Button crearC;
    /**
     * SingInFrame constructor
     * @param presenter
     */

    public SingInFrame(ActionListener presenter){
        backgroundP = new JPanel();
        tfu = new TextField();
        tfp = new TextField();
        tfm = new TextField();
        crearC = new Button();

        this.setTitle("Shelter Pages - Sing Up");
        backgroundP.setSize(750, 590);
        backgroundP.setLayout(null);
        backgroundP.setBackground(Colour.LIGHT_BG);

        logo = new ImageIcon( FileManager.getValue("urlLogo"));
        logoLabel = new JLabel(logo);
        logoLabel.setBounds(270, 40, 192, 223);
        backgroundP.add(logoLabel);
        forTFU = new TextPrompt("Ingresa un usuario", tfu);
        forTFU.changeAlpha(0.5f);
        tfu.setBounds(216, 290, 300, 40);
        forTFP = new TextPrompt("Ingresa una contraseña", tfp);
        forTFP.changeAlpha(0.5f);
        tfp.setBounds(216, 340, 300, 40);
        forTFM = new TextPrompt("Ingresa un monto de dinero inicial", tfm);
        forTFM.changeAlpha(0.5f);
        tfm.setBounds(216, 390, 300, 40);
        backgroundP.add(tfm);
        backgroundP.add(tfu);
        backgroundP.add(tfp);

        crearC.setText("Crear Cuenta");
        crearC.addActionListener(presenter);
        crearC.setActionCommand("crearS");
        crearC.setBounds(295, 450, 150, 40);
        backgroundP.add(crearC);
        this.add(backgroundP);
    }

    public TextField getTfu() {
        return tfu;
    }

    public TextField getTfp() {
        return tfp;
    }

    public TextField getTfm() {
        return tfm;
    }

    
}
