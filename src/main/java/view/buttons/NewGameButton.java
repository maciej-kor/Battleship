package view.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NewGameButton extends JButton implements MouseListener {

    private ImageIcon newGameButtonImg;
    private ImageIcon newGameButtonEnteredImg;

    public NewGameButton() {


        this.setContentAreaFilled(false);
        this.setOpaque(false);
        ImageIcon imageNextButton = new ImageIcon(getClass().getResource("nextButton.png"));
        Image nextBttn = imageNextButton.getImage();
        newGameButtonImg = new ImageIcon(nextBttn.getScaledInstance(265,64, Image.SCALE_AREA_AVERAGING));
        newGameButtonEnteredImg = new ImageIcon(nextBttn.getScaledInstance(200,58, Image.SCALE_AREA_AVERAGING));
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

