package view.panels;

import model.Player;
import model.Ship;
import controller.Controller;
import view.buttons.FieldLabel;

import javax.swing.*;
import java.awt.*;

public class RandomShipsBoardPanel extends JPanel {

    private FieldLabel[][] jLabels;
    private Player player;

    private ImageIcon imageIconWater, imageIconShip;

    public RandomShipsBoardPanel(Controller controller, Player player) {

        this.player = player;
        GridLayout gridLayout = new GridLayout(10, 10);
        this.setLayout(gridLayout);
        addIcons();
        createJLabels(10);
        this.setVisible(true);
    }

    private void createJLabels(int gameBoardSize) {

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


    private void addIcons() {

        ImageIcon imageIconWater1 = new ImageIcon(getClass().getResource("water.png"));
        Image imageWater = imageIconWater1.getImage();
        imageIconWater = new ImageIcon(imageWater.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHitt = new ImageIcon(getClass().getResource("hit.png"));
        Image imageHit = imageIconHitt.getImage();
        imageIconShip = new ImageIcon(imageHit.getScaledInstance(60, 60, Image.SCALE_DEFAULT));
    }

    protected void updateFieldStatus(Ship[] shipArray) {

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
