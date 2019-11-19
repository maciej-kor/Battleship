package Model.gui;

import Model.Field;
import Model.GameControler;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldButton extends JButton implements MouseListener {

    int x;
    int y;
    GameControler game;
    Player player;
    int status;
    ImageIcon imageIcon;

    FieldButton(GameControler game, Player player) {

        this.game = game;
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
        if (status == 2)
            this.setIcon(BoardPanel.imageIconWreck);
        this.status = status;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println(player.getName());
        if (status == 0) {

            game.shot(x, y, player);
            int status = game.getGameBoard(player).getGameBoardControler().getFieldStatus(getxX(), getyY(), player);
            System.out.println(status);

            if (status == -1) {
                this.status = status;
                this.setIcon(BoardPanel.imageIconMissedShot);
            } else if (status == 1) {
                this.status = status;
                this.setIcon(BoardPanel.imageIconHit);
            } else if (status == 2) {
                this.status = status;
                this.setIcon(BoardPanel.imageIconWreck);
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (status == 0) {
            this.setIcon(BoardPanel.imageIconEntered);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (status == 0) {
            this.setIcon(BoardPanel.imageIconWater);
        }
    }
}
