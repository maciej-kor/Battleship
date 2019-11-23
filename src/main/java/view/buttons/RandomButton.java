package view.buttons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RandomButton extends JButton implements MouseListener {

    private static ImageIcon randomButtonImg;
    private static ImageIcon randomButtonEnteredImg;

    public RandomButton(){

        randomButtonEnteredImg = new ImageIcon(getClass().getResource("randomEntered.png"));

        this.setContentAreaFilled(false);
        this.setOpaque(false);
        randomButtonImg = new ImageIcon(getClass().getResource("random.png"));
        this.setIcon(randomButtonImg);
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
        this.setIcon(randomButtonEnteredImg);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(randomButtonImg);
    }
}
