package Model.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    public MainFrame() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        MainPanel mainPanel = new MainPanel();
        this.add(mainPanel);
        this.pack();
        setWindowInCenter();
    }

    private void setWindowInCenter() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameDimension = this.getSize();

        this.setLocation((screenSize.width / 2 - frameDimension.width / 2), (screenSize.height / 2 - frameDimension.height / 2));
    }

}
