package Model;

import java.util.List;

public interface GameControler {

    void addPlayer(String name);

    void shot(int x, int y, GameBoard gameBoard);

    boolean checkIfWin(GameBoard gameBoard);

    List<GameBoard> getGameBoard();

}
