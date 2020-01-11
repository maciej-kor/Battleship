package view.panels;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrame extends JFrame implements WindowListener {

    Controller controller;

    public MainFrame(Controller controller) {

        this.controller = controller;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        //setting frame icon
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("appIcon.png"));
        Image appIcon = imageIcon.getImage();
        this.setIconImage(appIcon);

        this.setTitle("Battleship");
        addWindowListener(this);

    }

    public void setWindowInCenter() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameDimension = this.getSize();

        this.setLocation((screenSize.width / 2 - frameDimension.width / 2), (screenSize.height / 2 - frameDimension.height / 2));
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        controller.getMusicObject().stopMusic();
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        controller.getMusicObject().startMusic();
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
