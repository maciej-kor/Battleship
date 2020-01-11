package view.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ExitButton extends JButton implements MouseListener {

    private static ImageIcon exitButtonImg;
    private static ImageIcon exitButtonEnteredImg;

    public ExitButton() {


        this.setContentAreaFilled(false);
        this.setOpaque(false);
        ImageIcon imageNextButton = new ImageIcon(getClass().getResource("exitButton.png"));
        Image nextBttn = imageNextButton.getImage();
        exitButtonImg = new ImageIcon(nextBttn.getScaledInstance(265,64, Image.SCALE_AREA_AVERAGING));
        exitButtonEnteredImg = new ImageIcon(nextBttn.getScaledInstance(200,58, Image.SCALE_AREA_AVERAGING));
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
