package view.buttons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NewGameButton extends JButton implements MouseListener {

    private ImageIcon newGameButtonImg;
    private ImageIcon newGameButtonEnteredImg;

    public NewGameButton() {

        newGameButtonEnteredImg = new ImageIcon(getClass().getResource("newGameButtonEntered.png"));

        this.setContentAreaFilled(false);
        this.setOpaque(false);
        newGameButtonImg = new ImageIcon(getClass().getResource("newGameButton.png"));
        this.setIcon(newGameButtonImg);
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
        this.setIcon(newGameButtonEnteredImg);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(newGameButtonImg);
    }
}

