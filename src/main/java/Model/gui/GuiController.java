package Model.gui;

import Model.*;

import javax.swing.*;
import java.util.List;


public class GuiController {

    static GameControler game = new Game();
    static StartingPanel startingPanel;
    static MainFrame mainFrame;
    FieldButton fieldButton = new FieldButton();
    static MainPanel mainPanel = new MainPanel();
    static int x, y = 0;

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
            mainPanel = new MainPanel();
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

    public int loadFieldState(int x, int y, Player player) {

        final int EMPTY_FIELD = 0;
        final int MISSED_SHOT = -1;
        final int HIT = 1;
        final int WRECK = 2;

        List<Field> fields = game.getGameBoard(player).getGameBoardControler().getFields();

        for (Field f : fields) {
            if (x == f.getX() && y == f.getY()) {
                f.getFieldState();
                if (f.getFieldState().equals(FieldState.EMPTY)) {
                    return EMPTY_FIELD;
                } else if (f.getFieldState().equals(FieldState.HIT)) {
                    return HIT;
                } else if (f.getFieldState().equals(FieldState.MISSED_SHOT)) {
                    return MISSED_SHOT;
                } else if (f.getFieldState().equals(FieldState.WRECK)) {
                    return WRECK;
                }
            }
        }
        return -2;
    }

}
