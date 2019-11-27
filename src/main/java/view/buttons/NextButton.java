package view.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NextButton extends JButton implements MouseListener {

    private static ImageIcon nextButtonImg;
    private static ImageIcon nextButtonEnteredImg;

    public NextButton() {


        this.setContentAreaFilled(false);
        this.setOpaque(false);
        ImageIcon imageNextButton = new ImageIcon(getClass().getResource("nextButton.png"));
        Image nextBttn = imageNextButton.getImage();
        nextButtonImg = new ImageIcon(nextBttn.getScaledInstance(265,64, Image.SCALE_AREA_AVERAGING));
        nextButtonEnteredImg = new ImageIcon(nextBttn.getScaledInstance(200, 58, Image.SCALE_AREA_AVERAGING));
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
