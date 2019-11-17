package Model.gui;

import javax.swing.*;
import java.awt.*;

public class StartingFrame extends JFrame {

    public StartingFrame(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        StartingPanel startingPanel = new StartingPanel();
        this.add(startingPanel);
        this.pack();
        setWindowInCenter();


        //String filePath = "/src/main/resources/Model/sounds/theme.mp3";

    }

    private void setWindowInCenter() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameDimension = this.getSize();

        this.setLocation((screenSize.width / 2 - frameDimension.width / 2), (screenSize.height / 2 - frameDimension.height / 2));
    }


}
