package Model.gui;

import Model.Game;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldButton extends JButton implements MouseListener {

    int x;
    int y;

    FieldButton(){

        this.setContentAreaFilled(false);
        this.setIcon(BoardPanel.imageIconWater);
        this.setBorder(null);

        addMouseListener(this);

    }

    public int getx() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int gety() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GuiController.x = x;
        GuiController.y = y;

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
