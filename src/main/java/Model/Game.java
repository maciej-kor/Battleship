package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game implements GameControler {

    Map<Player, GameBoard> playerGameBoardMap = new HashMap<>();
    List<Player> players = new ArrayList<>();
    List<GameBoard> gameBoards = new ArrayList<>();

    @Override
    public void addPlayer(String name) {

        boolean nameExists = false;

        for (Player player : players) {

            if (player.getName() == name) {
                nameExists = true;
            }
        }

        if (!nameExists) {

            Player player = new Player();
            player.setName(name);
            Player.setWins(0);
            players.add(player);
            GameBoard gameBoard = new GameBoard(10);
            gameBoard.setPlayer(player);

            gameBoards.add(gameBoard);

            playerGameBoardMap.put(player, gameBoard);

        }
    }

    @Override
    public void shot(int x, int y, GameBoard gameBoard) {

        gameBoard.getGameBoardControler().shot(x, y);

    }

    @Override
    public boolean checkIfWin(GameBoard gameBoard) {
        if (gameBoard.getGameBoardControler().getShipwreckNumber() == 10)
            return true;
        else
            return false;
    }

    @Override
    public List<GameBoard> getGameBoard() {
        return gameBoards;
    }


}
