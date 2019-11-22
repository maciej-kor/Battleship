package view.panels;

import model.Player;
import model.Ship;
import controller.Controller;

import javax.swing.*;
import java.awt.*;

import static controller.Controller.playerList;


public class RandomShipsPanel extends JPanel {

    private Controller controller;
    private RandomShipsBoardPanel boardPanel;
    private Player player;
    private Ship[] shipArray;
    static int numerGraczaLosujacego = 0;

    public RandomShipsPanel(Controller controller, Player player) {

        this.setLayout(null);
        this.controller = controller;
        this.player = player;

        boardPanel = new RandomShipsBoardPanel(controller, player);
        boardPanel.setBounds(20, 20, 600, 600);
        boardPanel.setVisible(true);

        this.setVisible(true);

        this.add(boardPanel);

        JButton random = new JButton("Random");
        random.setBounds(10, 650, 100, 20);
        this.add(random);

        JButton next = new JButton("Next");
        next.setBounds(200, 650, 100, 20);
        this.add(next);


        ImageIcon img = new ImageIcon(getClass().getResource("background.jpg"));
        JLabel background = new JLabel(img, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);

        random.addActionListener(e -> randomButton());
        next.addActionListener(e -> nextButton());

        add(background);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(720, 720);
    }

    public void randomButton() {

        this.shipArray = controller.randomShips(player);
        boardPanel.aktualizujStanPol(shipArray);

    }

    private void nextButton() {

        numerGraczaLosujacego++;
        if (numerGraczaLosujacego < 2)
            controller.displayLoginWindow(playerList.get(numerGraczaLosujacego));
        else
            controller.displayGameWindow();
    }


    public RandomShipsBoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void setBoardPanel(RandomShipsBoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }
}
