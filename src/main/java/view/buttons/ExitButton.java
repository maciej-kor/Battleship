package view.buttons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ExitButton extends JButton implements MouseListener {

    private static ImageIcon exitButtonImg;
    private static ImageIcon exitButtonEnteredImg;

    public ExitButton() {

        exitButtonEnteredImg = new ImageIcon(getClass().getResource("exitButtonEntered.png"));

        this.setContentAreaFilled(false);
        this.setOpaque(false);
        exitButtonImg = new ImageIcon(getClass().getResource("exitButton.png"));
        this.setIcon(exitButtonImg);
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
        this.setIcon(exitButtonEnteredImg);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(exitButtonImg);
    }
}
