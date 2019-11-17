package Model.gui;

import Model.*;

import javax.swing.*;
import java.util.List;


public class GuiController {

    static GameControler game = new Game();
    static StartingPanel startingPanel;
    static MainFrame mainFrame;
    static MainPanel mainPanel = new MainPanel(game);

    public GuiController() {
        addFrame();
        addStartPanel();
    }

    public void addFrame() {
        mainFrame = new MainFrame();
    }

    public void addStartPanel() {
        startingPanel = new StartingPanel();
        startingPanel.setVisible(true);
        mainFrame.add(startingPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();
    }

    public static void nextButtonAction(String name1, String name2) {
        nextPanel(name1, name2);
    }

    public static void nextPanel(String name1, String name2) {

        if (name1.equals("") || name2.equals("")) {
            JOptionPane.showMessageDialog(startingPanel, "I said input your name soldier! Listen to your commander or leave this ship!");
        } else {
            game.addPlayer(name1);
            game.addPlayer(name2);
            mainFrame.setVisible(false);
            MainFrame mainFrame = new MainFrame();

            mainPanel = new MainPanel(game);

            mainFrame.add(mainPanel);
            mainFrame.pack();
            mainFrame.setWindowInCenter();
            mainPanel.setVisible(true);
        }

    }

    public void randomCoordinates(Player player) {
        List<GameBoard> gameBoards = game.getGameBoards();

        for (GameBoard o : gameBoards) {
            if (o.getPlayer().getName().equals(player.getName())) {
                o.randomShipCoordinates();
            }
        }
    }


    public static void shoot(int x, int y, Player player) {

        game.shot(x, y, player);

    }

}
