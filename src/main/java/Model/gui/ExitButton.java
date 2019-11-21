package Model.gui;

import javax.swing.*;

import static Model.gui.NextButton.nextButtonImg;

public class ExitButton extends JButton {

    public ExitButton() {

        this.setContentAreaFilled(false);
        this.setOpaque(false);
        nextButtonImg = new ImageIcon(getClass().getResource("exitButton.png"));
        this.setIcon(nextButtonImg);
        this.setBorder(null);

    }
}
