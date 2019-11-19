package Model.gui;

import Model.Field;
import Model.Game;
import Model.GameControler;
import Model.Player;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    FieldButton[][] jButtons;
    GameControler game;
    Player player;

    public static ImageIcon imageIconWater;
    public static ImageIcon imageIconEntered;
    public static ImageIcon imageIconMissedShot;
    public static ImageIcon imageIconHit;
    public static ImageIcon imageIconWreck;


    public BoardPanel(GameControler game, Player player) {

        this.player = player;
        GridLayout gridLayout = new GridLayout(10, 10);
        this.game = game;
        this.setLayout(gridLayout);
        addIcons();
        createJButtons(10);
    }

    public void createJButtons(int gameBoardSize) {

        jButtons = new FieldButton[gameBoardSize][gameBoardSize];

        for (int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {

                FieldButton fieldButton = new FieldButton(game, player);
                fieldButton.setxX(i);
                fieldButton.setyY(j);
                jButtons[i][j] = fieldButton;
                this.add(jButtons[i][j]);

            }
        }

    }

    public void addIcons() {

        ImageIcon imageIconWater1 = new ImageIcon(getClass().getResource("water.png"));
        Image imageWater = imageIconWater1.getImage();
        imageIconWater = new ImageIcon(imageWater.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconEntered1 = new ImageIcon(getClass().getResource("water2.png"));
        Image imageEntered = imageIconEntered1.getImage();
        imageIconEntered = new ImageIcon(imageEntered.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconMissedShot1 = new ImageIcon(getClass().getResource("missedShot.png"));
        Image imageMissedShot = imageIconMissedShot1.getImage();
        imageIconMissedShot = new ImageIcon(imageMissedShot.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHit1 = new ImageIcon(getClass().getResource("hit.png"));
        Image imageHit = imageIconHit1.getImage();
        imageIconHit = new ImageIcon(imageHit.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHit12 = new ImageIcon(getClass().getResource("missShot.png"));
        Image imageHit1 = imageIconHit12.getImage();
        imageIconWreck = new ImageIcon(imageHit1.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

    }

    public FieldButton[][] getjButtons() {
        return jButtons;
    }

    public void setjButtons(FieldButton[][] jButtons) {
        //BoardPanel.jButtons = jButtons;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}
