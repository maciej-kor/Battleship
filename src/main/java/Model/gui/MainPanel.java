package Model.gui;

import Model.*;
import Model.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    Controller controller;

    BoardPanel[] boardPanelArray = new BoardPanel[2];

    public MainPanel(Controller controller) {

        this.controller = controller;


        if (controller.getGameBoardList().size() > 1) {

            Player player1 = controller.getGameBoardList().get(0).getPlayer();
            Player player2 = controller.getGameBoardList().get(1).getPlayer();

            setLayout(null);
            BoardPanel boardPanel1 = new BoardPanel(controller, player1);
            boardPanel1.setSize(boardPanel1.getPreferredSize());
            boardPanel1.setBounds(20, 100, boardPanel1.getPreferredSize().width, boardPanel1.getPreferredSize().height);
            this.add(boardPanel1);

            BoardPanel boardPanel2 = new BoardPanel(controller, player2);
            boardPanel2.setSize(boardPanel2.getPreferredSize());
            boardPanel2.setBounds(660, 100, boardPanel2.getPreferredSize().width, boardPanel2.getPreferredSize().height);
            this.add(boardPanel2);

            boardPanelArray[0] = boardPanel1;
            boardPanelArray[1] = boardPanel2;

            ImageIcon img = new ImageIcon("Background.jpg");
            JLabel background = new JLabel(img, JLabel.CENTER);
            background.setBounds(0, 0, 1280, 720);
            add(background);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }


    public BoardPanel getBoardPanel(Player player) {

        for (BoardPanel p : boardPanelArray) {

            if (p.getPlayer().getName().equals(player.getName()))
                return p;

        }
        return null;
    }

}
