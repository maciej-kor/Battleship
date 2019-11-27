package controller;

import model.*;
import view.Gui;
import view.music.MusicClass;

import java.util.List;
import java.util.Random;

public class Controller {

    public static List<Player> playerList;

    private GameInterface gameInterface = null;
    private Gui gui;
    private Player myMove;
    private MusicClass musicObject = new MusicClass();

    public Controller() {

        //musicObject.playMusic();
        startNewGame();

    }

    public void startNewGame() {

        if (gameInterface != null)
            gui.getMainFrame().setVisible(false);

        gameInterface = new Game();
        gui = new Gui(this);

    }

    public void addUsers(String name1, String name2) {

        gameInterface.addPlayer(name1);
        gameInterface.addPlayer(name2);

        playerList = gameInterface.getPlayers();

        if (twoPlayersExist()) {

            Random random = new Random();
            boolean randomWhoStart = random.nextBoolean();

            if (randomWhoStart) {
                myMove = gameInterface.getPlayers().get(0);
            } else {
                myMove = gameInterface.getPlayers().get(1);
            }

            displayLegendPanel();

        }

    }

    public void displayLegendPanel() {

        gui.createLegendPanel();

    }

    public void displayLoginWindow() {

        Player player = playerList.get(0);

        gui.createRandomPanel(player);

    }

    public void displayLoginWindow(Player player) {

        gui.createRandomPanel(player);

    }

    public void displayGameWindow() {

        gui.createGamePanel();

    }

    public void closeApplication() {
        gui.getMainFrame().dispose();
        System.exit(0);
    }

    public Ship[] randomShips(Player player) {

        List<Ship> shipList = gameInterface.randomShip(player);

        Ship[] shipArray = new Ship[shipList.size()];

        for (int i = 0; i < shipList.size(); i++) {
            shipArray[i] = shipList.get(i);
        }

        return shipArray;
    }

    public boolean twoPlayersExist() {

        if (gameInterface.getPlayers().size() == 0)
            return false;

        if (gameInterface.getPlayers().size() > 1) {

            if (gameInterface.getPlayers().size() == 2)
                return true;
            else
                return false;
        }

        return false;

    }

    public Player getMyMove() {

        // set the fog over the inactive player BoardPanel
        gui.setFog(myMove);

        return myMove;

    }

    public List<GameBoard> getGameBoardList() {
        return gameInterface.getGameBoards();
    }

    public void shoot(Player player, int x, int y) {

        gameInterface.shot(x, y, player);

        updateFieldsStatus(player);

        if (gameInterface.checkWinner() != null) {

            gui.createWinnerPanel(gameInterface.checkWinner());

        }

        for (Player p : playerList) {
            if (p.isNextMove()) {
                p.setNextMove(true);
                setMyMove(p);
            } else
                p.setNextMove(false);
        }

    }

    public void updateFieldsStatus(Player player) {

        int[][] fieldStates = gameInterface.getFieldsState(player);

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                int tmpStatus = fieldStates[j][i];
                gui.getGamePanel().getBoardPanelList(player).getjButtons()[i][j].setStatus(tmpStatus);
            }
        }

        gui.getGamePanel().getBoardPanelList(player).refreshIcons(10);

    }


    public void setMyMove(Player myMove) {
        this.myMove = myMove;
    }

    public MusicClass getMusicObject() {
        return musicObject;
    }

    public void setMusicObject(MusicClass musicObject) {
        this.musicObject = musicObject;
    }
}

