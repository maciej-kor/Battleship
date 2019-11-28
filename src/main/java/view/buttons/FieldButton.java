package view.buttons;

import model.Player;
import controller.Controller;
import view.panels.BoardPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldButton extends JButton implements MouseListener {

    private int x, y;
    private Controller controller;
    private Player player;
    private int status;

    //Wpięty controller pozwala na wykonywanie strzałów w mouseListenerze
    //Konstruktor do prawdziwego funkcjonującego przycisku
    public FieldButton(Controller controller, Player player) {

        this.controller = controller;
        this.player = player;
        this.setContentAreaFilled(false);
        this.setIcon(BoardPanel.imageIconWater);
        this.setBorder(null);

        addMouseListener(this);
    }

    public int getxX() {
        return x;
    }

    public void setxX(int x) {
        this.x = x;
    }

    public int getyY() {
        return y;
    }

    public void setyY(int y) {
        this.y = y;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (player.getName().equals(controller.getMyMove().getName())) {
            if (status == 0)
                controller.shoot(player, getxX(), getyY());
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (player.getName().equals(controller.getMyMove().getName())) {
            if (status == 0)
                controller.shoot(player, getxX(), getyY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (player.getName().equals(controller.getMyMove().getName())) {
            if (status == 0) {
                this.setIcon(BoardPanel.imageIconEntered);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (player.getName().equals(controller.getMyMove().getName())) {
            if (status == 0)
                this.setIcon(BoardPanel.imageIconWater);

        }
    }
}

