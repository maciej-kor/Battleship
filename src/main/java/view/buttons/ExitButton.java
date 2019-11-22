package view.buttons;

import javax.swing.*;

public class ExitButton extends JButton {

    public ExitButton() {

        this.setContentAreaFilled(false);
        this.setOpaque(false);
        NextButton.nextButtonImg = new ImageIcon(getClass().getResource("exitButton.png"));
        this.setIcon(NextButton.nextButtonImg);
        this.setBorder(null);

    }
}
