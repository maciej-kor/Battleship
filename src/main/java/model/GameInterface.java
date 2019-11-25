package model;

import java.util.List;

public interface GameInterface {

    boolean addPlayer(String name);

    void shot(int x, int y, Player player);

    Player checkWinner();

    List<GameBoard> getGameBoards();

    List<Player> getPlayers();

    List <Ship> randomShip(Player player);

    int[][] getFieldsState(Player player);



}
