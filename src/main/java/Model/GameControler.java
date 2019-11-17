package Model;

import java.util.List;
import java.util.Map;

public interface GameControler {

    void addPlayer(String name);

    void shot(int x, int y, Player player);

    boolean checkIfWin(Player player);

    GameBoard getGameBoard(Player player);

    List<GameBoard> getGameBoards();

    List<Player> getPlayers();
}
