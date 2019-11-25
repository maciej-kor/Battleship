package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game implements GameInterface {

    private Map<Player, GameBoard> playerGameBoardMap = new HashMap<>();
    private List<Player> players = new ArrayList<>();
    private List<GameBoard> gameBoards = new ArrayList<>();

    @Override
    public boolean addPlayer(String name) {

        if (players.size() > 0) {
            for (Player player : players) {

                if (player.getName().equals(name)) {
                    return false;
                }
            }
        }

        Player player = new Player();
        player.setName(name);
        Player.setWins(0);

        players.add(player);

        GameBoard gameBoard = new GameBoard(10);
        gameBoard.setPlayer(player);

        gameBoards.add(gameBoard);

        playerGameBoardMap.put(player, gameBoard);

        return true;

    }

    @Override
    public void shot(int x, int y, Player player) {

        boolean checkHit;

        checkHit = getPlayerGameBoardMap().get(player).getGameBoardControler().changeStateOfSelectedField(x, y);

        if (checkHit) {

            if (players.get(0).getName().equals(player.getName())) {

                players.get(0).setNextMove(true);
                players.get(1).setNextMove(false);

            } else {

                players.get(0).setNextMove(false);
                players.get(1).setNextMove(true);

            }

        } else {

            if (players.get(0).getName().equals(player.getName())) {

                players.get(0).setNextMove(false);
                players.get(1).setNextMove(true);

            } else {

                players.get(0).setNextMove(true);
                players.get(1).setNextMove(false);

            }
        }
    }

    @Override
    public Player checkWinner() {

        for (Player p : players) {

            // compare number of ships and number of wrecks
            if (getPlayerGameBoardMap().get(p).getGameBoardControler().getShipwreckNumber() == getPlayerGameBoardMap().get(p).getGameBoardControler().getShipList().size())
                return p;

        }

        return null;
    }

    public List<GameBoard> getGameBoards() {
        return gameBoards;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public List<Ship> randomShip(Player player) {

        GameBoard gameBoard = getPlayerGameBoardMap().get(player);
        gameBoard.getGameBoardControler().randomShipsCoordinates(10);
        return gameBoard.getGameBoardControler().getShipList();

    }

    @Override
    public int[][] getFieldsState(Player player) {

        int[][] fieldStates = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fieldStates[i][j] = playerGameBoardMap.get(player).getGameBoardControler().getFieldStatus(j, i, player);
            }
        }
        return fieldStates;
    }

    public Map<Player, GameBoard> getPlayerGameBoardMap() {
        return playerGameBoardMap;
    }

    public void setPlayerGameBoardMap(Map<Player, GameBoard> playerGameBoardMap) {
        this.playerGameBoardMap = playerGameBoardMap;
    }


}
