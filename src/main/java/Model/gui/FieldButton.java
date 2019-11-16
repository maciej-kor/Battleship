package Model.gui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldButton extends JButton implements MouseListener {

    FieldButton(){

        this.setContentAreaFilled(false);
        this.setIcon(BoardPanel.imageIconWater);
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
        this.setIcon(BoardPanel.imageIconEntered);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(BoardPanel.imageIconWater);
    }
}
