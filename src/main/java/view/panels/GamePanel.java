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
            player1Label.setText("Player 1: " + player1.getName().toUpperCase());
            player1Label.setBounds(20, 130, 550, 40);
            player1Label.setFont(font);
            this.add(player1Label);

            BoardPanel boardPanel1 = new BoardPanel(controller, player1);
            boardPanel1.setSize(boardPanel1.getPreferredSize());
            boardPanel1.setBounds(20, 180, boardPanel1.getPreferredSize().width, boardPanel1.getPreferredSize().height);

            JLabel player2Label = new JLabel();
            player2Label.setText("Player 2: " + player2.getName().toUpperCase());
            player2Label.setBounds(660, 130, 550, 40);
            player2Label.setFont(font);
            this.add(player2Label);

            BoardPanel boardPanel2 = new BoardPanel(controller, player2);
            boardPanel2.setSize(boardPanel2.getPreferredSize());
            boardPanel2.setBounds(660, 180, boardPanel2.getPreferredSize().width, boardPanel2.getPreferredSize().height);

            this.add(boardPanel1);
            this.add(boardPanel2);

            boardPanelArray[0] = boardPanel1;
            boardPanelArray[1] = boardPanel2;

            ImageIcon img2 = new ImageIcon(getClass().getResource("baner.png"));
            Image imageBaner = img2.getImage();
            ImageIcon baner = new ImageIcon(imageBaner.getScaledInstance(510, 277, Image.SCALE_AREA_AVERAGING));
            JLabel banerLabel = new JLabel(baner);
            banerLabel.setBounds(0, -25, 1280,200 );
            add(banerLabel);

            ImageIcon img3 = new ImageIcon(getClass().getResource("pasek.png"));
            Image imagePasek = img3.getImage();
            ImageIcon pasek = new ImageIcon(imagePasek);
            JLabel pasek1 = new JLabel(pasek);
            pasek1.setBounds(20,125,600,50);
            add(pasek1);

            JLabel pasek2 = new JLabel(pasek);
            pasek2.setBounds(660, 125, 600, 50);
            add(pasek2);

            ImageIcon img = new ImageIcon(getClass().getResource("background.jpg"));
            Image imageBackground = img.getImage();
            ImageIcon background = new ImageIcon(imageBackground.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH));
            JLabel backgroundLabel = new JLabel(background, JLabel.CENTER);
            backgroundLabel.setBounds(0, 0, 1280, 800);
            add(backgroundLabel);


        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 800);
    }


    public BoardPanel getBoardPanelList(Player player) {

        for (BoardPanel p : boardPanelArray) {

            if (p.getPlayer().getName().equals(player.getName()))
                return p;

        }
        return null;
    }

}
