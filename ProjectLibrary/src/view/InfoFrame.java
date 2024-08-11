package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import presenter.FileManager;

/**
 * InfoFrame class extends JFrame
 * This frame sets the aset for anther frames, it sets the size, icon and a font.
 * @author Juan
 * @version 29/05/2024
 */

public class InfoFrame extends JFrame{
    
    private String projectRoute;
    private Image logo;

    /**
     * InfoFrame class constructor
     */

    public InfoFrame(){
        projectRoute = new String(System.getProperty("user.dir"));
        logo = new ImageIcon(projectRoute + FileManager.getValue("urlLogoIcon")).getImage();
        this.setIconImage(logo);
        this.setSize(750, 590);
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

    
}