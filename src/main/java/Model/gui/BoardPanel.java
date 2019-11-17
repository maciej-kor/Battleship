package Model.gui;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    JButton[][] jButtons;

    public static ImageIcon imageIconWater;
    public static ImageIcon imageIconEntered;
    public static ImageIcon imageIconMissedShot;
    public static ImageIcon imageIconHit;
    public static ImageIcon imageIconHit11;

    public BoardPanel() {

        GridLayout gridLayout = new GridLayout(10, 10);
        this.setLayout(gridLayout);
        addIcons();
        createJButtons(10);

    }

    public void createJButtons(int gameBoardSize) {

        jButtons = new FieldButton[gameBoardSize][gameBoardSize];

        for (int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {

                FieldButton fieldButton = new FieldButton();
                fieldButton.setX(i);
                fieldButton.setY(j);
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

        ImageIcon imageIconMissedShot1 = new ImageIcon(getClass().getResource("missShot.png"));
        Image imageMissedShot = imageIconMissedShot1.getImage();
        imageIconMissedShot = new ImageIcon(imageMissedShot.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHit1 = new ImageIcon(getClass().getResource("hit.png"));
        Image imageHit = imageIconHit1.getImage();
        imageIconHit = new ImageIcon(imageHit.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHit12 = new ImageIcon(getClass().getResource("missedShot.png"));
        Image imageHit1 = imageIconHit12.getImage();
        imageIconHit11 = new ImageIcon(imageHit1.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}
