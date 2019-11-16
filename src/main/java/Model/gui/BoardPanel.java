package Model.gui;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    JButton[][] jButtons;

    public static ImageIcon imageIconWater;
    public static ImageIcon imageIconEntered;

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

                jButtons[i][j] = new FieldButton();
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

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}
