package Model.gui;

import javax.swing.*;
import java.awt.*;

public class PreviousButton extends JButton {

    private static ImageIcon previousButtonImg;

    public PreviousButton(){
        this.setContentAreaFilled(false);
        this.setIcon(previousButtonImg);
        this.setBorder(null);
        addIcon();
    }

    public void addIcon(){
        ImageIcon previousButtonImage = new ImageIcon(getClass().getResource("previousButton.png"));
        Image imagePreviousButton = previousButtonImage.getImage();
        previousButtonImg = new ImageIcon(imagePreviousButton.getScaledInstance(90, 90, Image.SCALE_AREA_AVERAGING));
    }

}
