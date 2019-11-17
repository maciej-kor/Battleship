package Model.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static StartingPanel startingPanel;
    public static MainPanel mainPanel;


    public MainFrame() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        startingPanel = new StartingPanel();
        startingPanel.setVisible(true);
        this.add(startingPanel);
        //mainPanel = new MainPanel();
        //mainPanel.setVisible(false);
        //this.add(mainPanel);
        this.pack();
        setWindowInCenter();

        String filePath = "theme.wav";
        MusicClass musicObject = new MusicClass();
        musicObject.playMusic(filePath);
    }

    private void setWindowInCenter() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameDimension = this.getSize();

        this.setLocation((screenSize.width / 2 - frameDimension.width / 2), (screenSize.height / 2 - frameDimension.height / 2));
    }

}
