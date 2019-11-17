package Model.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButton extends JButton {

    public static ImageIcon nextButtonImg;
    boolean klik = false;

    public NextButton() {
        this.setContentAreaFilled(false);
        this.setIcon(nextButtonImg);
        this.setBorder(null);
        this.setBounds(850,150, 90, 90);
        addIcon();
    }

    public void addIcon() {
        ImageIcon nextButtonImage = new ImageIcon(getClass().getResource("nextButton.png"));
        Image imageNextButton = nextButtonImage.getImage();
        nextButtonImg = new ImageIcon(imageNextButton.getScaledInstance(90, 90, Image.SCALE_AREA_AVERAGING));
    }

}
