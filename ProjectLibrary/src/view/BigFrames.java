package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import presenter.FileManager;

/**
 * BigFrames class extends JFrame
 * This class sets the aset for anther frames, it sets the size, icon and a font.
 * @author Juan
 * @version 29/05/2024
 */

public class BigFrames extends JFrame{
    
    private Image logo;
    private String projectRoute;
    private Font aston;
    private Font happy;
    private Font bogart;

    /**
     * BigFrames constructor
     */
    public BigFrames(){
        projectRoute = new String(System.getProperty("user.dir"));
        logo = new ImageIcon( FileManager.getValue("urlLogoIcon")).getImage();

        try {
            aston = Font.createFont(Font.TRUETYPE_FONT, new File( "resources/Astonpoliz.otf")).deriveFont(Font.BOLD,16);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            happy = Font.createFont(Font.TRUETYPE_FONT, new File("resources/Simply-Happy.otf")).deriveFont(Font.BOLD,24);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bogart = Font.createFont(Font.TRUETYPE_FONT, new File( "resources/Bogart-Bold-trial.ttf")).deriveFont(Font.BOLD,70);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.setIconImage(logo);
        this.setSize(1920, 1080);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
    }

    /**
     * Returns the project route.
     *
     * @return the project route
     */
    public String getProjectRoute() {
        return projectRoute;
    }

    /**
     * Sets the project route for this object.
     *
     * @param  projectRoute  the new project route to be set
     */
    public void setProjectRoute(String projectRoute) {
        this.projectRoute = projectRoute;
    }

    /**
     * Returns Aston Font
     * 
     * @return the Aston font
     */
    public Font getAston() {
        return aston;
    }

    /**
     * Sets Aston font for this object.
     * 
     * @param aston Aston font
     */
    public void setAston(Font aston) {
        this.aston = aston;
    }

    /**
     * Returns Happy Font
     * 
     * @return the happy font
     */
    public Font getHappy() {
        return happy;
    }

    /**
     * Sets Happy font for this object
     * 
     * @param happy
     */
    public void setHappy(Font happy) {
        this.happy = happy;
    }

    /**
     * Returns Bogart Font
     * 
     * @return the bogart font
     */
    public Font getBogart() {
        return bogart;
    }

    /**
     * Sets Bogart font for this object
     * 
     * @param bogart
     */
    public void setBogart(Font bogart) {
        this.bogart = bogart;
    }

    
}