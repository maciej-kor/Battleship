package Model.gui;

import Model.Player;
import Model.Ship;
import Model.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class RandomBoardPanel extends JPanel {

    FieldLabel[][] jLabels;
    Controller controller;
    Player player;

    public static ImageIcon imageIconWater, imageIconShip;

    public RandomBoardPanel(Controller controller, Player player) {

        this.controller = controller;
        this.player = player;
        GridLayout gridLayout = new GridLayout(10, 10);
        this.setLayout(gridLayout);
        addIcons();
        createJLabels(10);
        this.setVisible(true);
    }

    public void createJLabels(int gameBoardSize) {

        jLabels = new FieldLabel[gameBoardSize][gameBoardSize];

        for (int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {

                FieldLabel fieldLabel = new FieldLabel();
                fieldLabel.setxX(j);
                fieldLabel.setyY(i);
                fieldLabel.setIcon(imageIconWater);
                jLabels[j][i] = fieldLabel;
                this.add(fieldLabel);

            }
        }
    }


    public void addIcons() {

        ImageIcon imageIconWater1 = new ImageIcon(getClass().getResource("water.png"));
        Image imageWater = imageIconWater1.getImage();
        imageIconWater = new ImageIcon(imageWater.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconWater3 = new ImageIcon(getClass().getResource("hit.png"));
        Image imageWater2 = imageIconWater3.getImage();
        imageIconShip = new ImageIcon(imageWater2.getScaledInstance(60, 60, Image.SCALE_DEFAULT));
    }

    public void aktualizujStanPol(Ship[] shipArray) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                jLabels[i][j].setIcon(imageIconWater);
            }
        }

        for (Ship ship : shipArray) {

            for (int j = 0; j < ship.getLength(); j++) {

                int[][] cord = ship.getCoordinates();

                int y = cord[j][0];
                int x = cord[j][1];

                jLabels[x][y].setIcon(imageIconShip);

            }
        }

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

}
