package Model.gui;

import Model.Player;
import Model.Ship;
import Model.controller.Controller;

import javax.swing.*;
import java.awt.*;

import static Model.controller.Controller.playerList;


public class RandomShipsPanel extends JPanel {

    Controller controller;
    RandomBoardPanel boardPanel;
    Player player;
    Ship[] shipArray;
    static int numerGraczaLosujacego = 0;

    public RandomShipsPanel(Controller controller, Player player) {

        this.setLayout(null);
        this.controller = controller;
        this.player = player;

        boardPanel = new RandomBoardPanel(controller, player);
        boardPanel.setBounds(20, 20, 600, 600);
        boardPanel.setVisible(true);

        this.setVisible(true);

        this.add(boardPanel);

        JButton losuj = new JButton("losuj");
        losuj.setBounds(10, 650, 100, 20);
        this.add(losuj);

        JButton dalej = new JButton("dalej");
        dalej.setBounds(200, 650, 100, 20);
        this.add(dalej);


        ImageIcon img = new ImageIcon("Background.jpg");
        JLabel background = new JLabel(img, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);

        losuj.addActionListener(e -> losujButton());
        dalej.addActionListener(e -> dalejButton());

        add(background);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(720, 720);
    }

    public void losujButton() {

        this.shipArray = controller.losujStatki(player);
        boardPanel.aktualizujStanPol(shipArray);

    }

    public void dalejButton() {

        numerGraczaLosujacego++;
        if (numerGraczaLosujacego < 2)
            controller.oknoLosowania(playerList.get(numerGraczaLosujacego));
        else
            controller.zacznijRozgrywke();
    }


    public RandomBoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void setBoardPanel(RandomBoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }
}
