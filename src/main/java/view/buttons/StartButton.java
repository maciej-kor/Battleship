package view.buttons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartButton extends JButton implements MouseListener {

    static ImageIcon startButtonImg;
    static ImageIcon startButtonEnteredImg;


    public StartButton() {

        startButtonEnteredImg = new ImageIcon(getClass().getResource("startButtonEntered.png"));

        this.setContentAreaFilled(false);
        this.setOpaque(false);
        startButtonImg = new ImageIcon(getClass().getResource("startButton.png"));
        this.setIcon(startButtonImg);
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
        this.setIcon(startButtonEnteredImg);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(startButtonImg);
    }
}
