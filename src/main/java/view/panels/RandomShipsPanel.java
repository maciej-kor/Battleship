package view.panels;

import model.Player;
import model.Ship;
import controller.Controller;
import view.buttons.ExitButton;
import view.buttons.NextButton;
import view.buttons.RandomButton;

import javax.swing.*;
import java.awt.*;

import static controller.Controller.playerList;


public class RandomShipsPanel extends JPanel {

    private Controller controller;
    private RandomShipsBoardPanel randomShipsBoardPanel;
    private Player player;
    private Ship[] shipArray;
    private static int numerGraczaLosujacego = 0;
    private boolean randomButtonFlag = false;

    public RandomShipsPanel(Controller controller, Player player) {

        this.setLayout(null);
        this.controller = controller;
        this.player = player;

        randomShipsBoardPanel = new RandomShipsBoardPanel(controller, player);
        randomShipsBoardPanel.setBounds(40, 40, 600, 600);
        randomShipsBoardPanel.setVisible(true);
        this.setVisible(true);
        this.add(randomShipsBoardPanel);

        Font fontLabel = new Font("ARIAL", Font.PLAIN, 30);
        JLabel jLabel = new JLabel();
        jLabel.setBounds(700, 40, 200, 70);
        jLabel.setText(player.getName().toUpperCase());
        jLabel.setFont(fontLabel);
        this.add(jLabel);

        ImageIcon img3 = new ImageIcon(getClass().getResource("pasek.png"));
        Image imagePasek = img3.getImage();
        ImageIcon pasek = new ImageIcon(imagePasek.getScaledInstance(265, 50, Image.SCALE_AREA_AVERAGING));
        JLabel pasek1 = new JLabel(pasek);
        pasek1.setBounds(680,40,265,70);
        this.add(pasek1);

        RandomButton random = new RandomButton();
        random.setBounds(680, 145, 265, 64);
        this.add(random);

        NextButton next = new NextButton();
        next.setBounds(680, 340, 265, 64);
        this.add(next);

        ExitButton exitButton = new ExitButton();
        exitButton.setBounds(680, 576, 265, 64);
        this.add(exitButton);


        ImageIcon img = new ImageIcon(getClass().getResource("background.jpg"));
        JLabel background = new JLabel(img, JLabel.CENTER);

        background.setBounds(0, 0, 1280, 720);

        random.addActionListener(e -> randomButton());
        next.addActionListener(e -> nextButton());
        exitButton.addActionListener(e -> controller.closeApplication());

        add(background);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 680);
    }

    private void randomButton() {

        this.shipArray = controller.randomShips(player);
        randomShipsBoardPanel.updateFieldStatus(shipArray);
        randomButtonFlag = true;

    }

    private void nextButton() {

        if (!randomButtonFlag) {
            JOptionPane.showMessageDialog(this, "You must random your ships");
        } else {
            numerGraczaLosujacego++;
            if (numerGraczaLosujacego < 2)
                controller.displayLoginWindow(playerList.get(numerGraczaLosujacego));
            else{
                numerGraczaLosujacego = 0;
                controller.displayGameWindow();}

        }
    }


    public RandomShipsBoardPanel getRandomShipsBoardPanel() {
        return randomShipsBoardPanel;
    }

    public void setRandomShipsBoardPanel(RandomShipsBoardPanel randomShipsBoardPanel) {
        this.randomShipsBoardPanel = randomShipsBoardPanel;
    }
}
