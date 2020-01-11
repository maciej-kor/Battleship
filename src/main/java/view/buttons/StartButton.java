package view.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartButton extends JButton implements MouseListener {

    static ImageIcon startButtonImg;
    static ImageIcon startButtonEnteredImg;


    public StartButton() {


        this.setContentAreaFilled(false);
        this.setOpaque(false);
        ImageIcon imageNextButton = new ImageIcon(getClass().getResource("startButton.png"));
        Image nextBttn = imageNextButton.getImage();
        startButtonImg = new ImageIcon(nextBttn.getScaledInstance(265,64, Image.SCALE_AREA_AVERAGING));
        startButtonEnteredImg = new ImageIcon(nextBttn.getScaledInstance(200,58, Image.SCALE_AREA_AVERAGING));
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
