import Model.Game;
import Model.GameBoard;
import Model.GameControler;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        GameControler gameControler = new Game();
        gameControler.addPlayer("player1");
        gameControler.getGameBoard();

        List<GameBoard> gameBoards = gameControler.getGameBoard();

        gameControler.checkIfWin(gameBoards.get(0));

    }
}
