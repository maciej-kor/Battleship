package view.panels;

import model.Player;
import controller.Controller;
import view.buttons.FieldButton;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    private FieldButton[][] jButtons;
    private Controller controller;
    private Player player;
    private JLabel fog;

    public static ImageIcon imageIconWater;
    public static ImageIcon imageIconEntered;
    public static ImageIcon imageIconMissedShot;
    public static ImageIcon imageIconHit;
    public static ImageIcon imageIconWreck;
    public static ImageIcon imageIconMg;


    //Wywołanie konstruktora powoduje wywołanie metody addIcons()
    //Konstruktor do funkcjonującej macierzy
    public BoardPanel(Controller controller, Player player) {

        this.controller = controller;
        this.player = player;
        this.setLayout(null);
        addIcons();

        fog = new JLabel();
        this.add(fog);
        fog.setBounds(0,0,600,600);
        fog.setOpaque(false);
        fog.setIcon(imageIconMg);
        fog.setVisible(false);

        createJButtons(10);

    }

    //Tworzy FieldButtony w stosunku do wielkości planszy i przypisuje im współrzędne w macierzy
    public void createJButtons(int gameBoardSize) {

        jButtons = new FieldButton[gameBoardSize][gameBoardSize];

        for (int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {

                FieldButton fieldButton = new FieldButton(controller, player);
                fieldButton.setxX(j);
                fieldButton.setyY(i);
                fieldButton.setIcon(imageIconWater);
                fieldButton.setBounds(fieldButton.getxX()*60, fieldButton.getyY()*60, 60, 60);
                jButtons[j][i] = fieldButton;
                this.add(fieldButton);

            }
        }
    }

    //Metoda przechodzi po całej macierzy i przypisuje FieldButtonom ikony odpowiadające ich statusowi
    public void refreshIcons(int gameBoardSize) {

        for (int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {

                if (jButtons[i][j].getStatus() == -1) {
                    jButtons[i][j].setIcon(imageIconMissedShot);
                    this.add(jButtons[i][j]);
                } else if (jButtons[i][j].getStatus() == 1) {
                    jButtons[i][j].setIcon(imageIconHit);
                } else if (jButtons[i][j].getStatus() == 2) {
                    jButtons[i][j].setIcon(imageIconWreck);
                }

            }
        }

    }

    public void setFogImageVisible(){

        fog.setVisible(true);

    }

    public void setFogImageInvisible(){
        fog.setVisible(false);
    }


    //Przypisuje zmiennym ścieżki do plików oraz ustala skalowanie obrazu
    public void addIcons() {

        ImageIcon imageIconWater1 = new ImageIcon(getClass().getResource("water.png"));
        Image imageWater = imageIconWater1.getImage();
        imageIconWater = new ImageIcon(imageWater.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconEntered1 = new ImageIcon(getClass().getResource("selectField.png"));
        Image imageEntered = imageIconEntered1.getImage();
        imageIconEntered = new ImageIcon(imageEntered.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconMissedShot1 = new ImageIcon(getClass().getResource("missedShot.png"));
        Image imageMissedShot = imageIconMissedShot1.getImage();
        imageIconMissedShot = new ImageIcon(imageMissedShot.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHit1 = new ImageIcon(getClass().getResource("hit.png"));
        Image imageHit = imageIconHit1.getImage();
        imageIconHit = new ImageIcon(imageHit.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHit12 = new ImageIcon(getClass().getResource("wreck.png"));
        Image imageHit1 = imageIconHit12.getImage();
        imageIconWreck = new ImageIcon(imageHit1.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconMg1 = new ImageIcon(getClass().getResource("fog.png"));
        Image imageMg = imageIconMg1.getImage();
        imageIconMg = new ImageIcon(imageMg.getScaledInstance(600, 600, Image.SCALE_DEFAULT));

    }


    public FieldButton[][] getjButtons() {
        return jButtons;
    }

    public void setjButtons(FieldButton[][] jButtons) {
        this.jButtons = jButtons;
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
