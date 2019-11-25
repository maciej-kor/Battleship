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
    private RandomShipsBoardPanel boardPanel;
    private Player player;
    private Ship[] shipArray;
    private static int numerGraczaLosujacego = 0;
    private boolean randomButtonFlag = false;

    public RandomShipsPanel(Controller controller, Player player) {

        this.setLayout(null);
        this.controller = controller;
        this.player = player;

        boardPanel = new RandomShipsBoardPanel(controller, player);
        boardPanel.setBounds(40, 40, 600, 600);
        boardPanel.setVisible(true);
        this.setVisible(true);
        this.add(boardPanel);

        Font fontLabel = new Font("ARIAL", Font.PLAIN, 30);
        JLabel jLabel = new JLabel();
        jLabel.setBounds(680, 40, 200, 70);
        jLabel.setText(player.getName());
        jLabel.setFont(fontLabel);
        this.add(jLabel);

        RandomButton random = new RandomButton();
        random.setBounds(680, 145, 180, 64);
        this.add(random);

        NextButton next = new NextButton();
        next.setBounds(680, 340, 180, 64);
        this.add(next);

        ExitButton exitButton = new ExitButton();
        exitButton.setBounds(680, 576, 180, 64);
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
        return new Dimension(890, 680);
    }

    public void randomButton() {

        this.shipArray = controller.randomShips(player);
        boardPanel.aktualizujStanPol(shipArray);
        randomButtonFlag = true;

    }

    private void nextButton() {

        if (!randomButtonFlag) {
            JOptionPane.showMessageDialog(this, "You must random your ships firstly");
        } else {
            numerGraczaLosujacego++;
            if (numerGraczaLosujacego < 2)
                controller.displayLoginWindow(playerList.get(numerGraczaLosujacego));
            else
                controller.displayGameWindow();
        }
    }


    public RandomShipsBoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void setBoardPanel(RandomShipsBoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }
}
