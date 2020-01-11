package view.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RandomButton extends JButton implements MouseListener {

    private static ImageIcon randomButtonImg;
    private static ImageIcon randomButtonEnteredImg;

    public RandomButton(){


        this.setContentAreaFilled(false);
        this.setOpaque(false);
        ImageIcon imageNextButton = new ImageIcon(getClass().getResource("random.png"));
        Image nextBttn = imageNextButton.getImage();
        randomButtonImg = new ImageIcon(nextBttn.getScaledInstance(265,64, Image.SCALE_AREA_AVERAGING));
        randomButtonEnteredImg = new ImageIcon(nextBttn.getScaledInstance(200,58, Image.SCALE_AREA_AVERAGING));
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
