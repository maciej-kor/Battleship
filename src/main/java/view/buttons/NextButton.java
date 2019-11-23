package view.buttons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NextButton extends JButton implements MouseListener {

    private static ImageIcon nextButtonImg;
    private static ImageIcon nextButtonEnteredImg;

    public NextButton() {

        nextButtonEnteredImg = new ImageIcon(getClass().getResource("nextButtonEntered.png"));

        this.setContentAreaFilled(false);
        this.setOpaque(false);
        nextButtonImg = new ImageIcon(getClass().getResource("nextButton.png"));
        this.setIcon(nextButtonImg);
        this.setBorder(null);

        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setIcon(nextButtonEnteredImg);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(nextButtonImg);
    }
}
