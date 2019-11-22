package model;

public class GameBoard {

    private GameBoardControllerInterface gameBoardControler = new GameBoardControllerImpl();
    private Player player;
    private int gameBoardSize;

    public GameBoard(int gameBoardSize){
        gameBoardControler.addFields(gameBoardSize);
        gameBoardControler.randomShipsCoordinates(gameBoardSize);
    }

    public GameBoardControllerInterface getGameBoardControler() {
        return gameBoardControler;
    }

    public void setGameBoardControler(GameBoardControllerInterface gameBoardControllerInterface) {
        this.gameBoardControler = gameBoardControllerInterface;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getGameBoardSize() {
        return gameBoardSize;
    }

    public void setGameBoardSize(int gameBoardSize) {
        this.gameBoardSize = gameBoardSize;
    }
}
