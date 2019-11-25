package view.panels;

import model.*;
import controller.Controller;

import javax.swing.*;
import java.awt.*;

import static controller.Controller.playerList;

public class GamePanel extends JPanel {

    private BoardPanel[] boardPanelArray = new BoardPanel[2];

    public GamePanel(Controller controller) {


        Font font = new Font("ARIAL", Font.PLAIN, 36);

        if (controller.getGameBoardList().size() > 1) {

            Player player1 = playerList.get(0);
            Player player2 = playerList.get(1);

            setLayout(null);
            JLabel player1Label = new JLabel();
            player1Label.setText(player1.getName());
            player1Label.setBounds(20, 50, 300, 40);
            player1Label.setFont(font);
            this.add(player1Label);

            BoardPanel boardPanel1 = new BoardPanel(controller, player1);
            boardPanel1.setSize(boardPanel1.getPreferredSize());
            boardPanel1.setBounds(20, 100, boardPanel1.getPreferredSize().width, boardPanel1.getPreferredSize().height);

            JLabel player2Label = new JLabel();
            player2Label.setText(player2.getName());
            player2Label.setBounds(660, 50, 300, 40);
            player2Label.setFont(font);
            this.add(player2Label);

            BoardPanel boardPanel2 = new BoardPanel(controller, player2);
            boardPanel2.setSize(boardPanel2.getPreferredSize());
            boardPanel2.setBounds(660, 100, boardPanel2.getPreferredSize().width, boardPanel2.getPreferredSize().height);

            this.add(boardPanel1);
            this.add(boardPanel2);

            boardPanelArray[0] = boardPanel1;
            boardPanelArray[1] = boardPanel2;

            ImageIcon img = new ImageIcon(getClass().getResource("background.jpg"));
            JLabel background = new JLabel(img, JLabel.CENTER);
            background.setBounds(0, 0, 1280, 720);
            add(background);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }


    public BoardPanel getBoardPanelList(Player player) {

        for (BoardPanel p : boardPanelArray) {

            if (p.getPlayer().getName().equals(player.getName()))
                return p;

        }
        return null;
    }

}
