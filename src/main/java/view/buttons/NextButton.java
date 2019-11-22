package view.buttons;

import javax.swing.*;

public class NextButton extends JButton {

    public static ImageIcon nextButtonImg;

    public NextButton() {
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        nextButtonImg = new ImageIcon(getClass().getResource("startButton.png"));
        this.setIcon(nextButtonImg);
        this.setBorder(null);
    }


}
