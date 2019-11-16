package Model;

public class GameBoard {

    private GameBoardController gameBoardControler = new GameBoardControlerImpl();
    private Player player;
    private int gameBoardSize;

    public GameBoard(int gameBoardSize){
        gameBoardControler.addGameBoard(gameBoardSize);
        gameBoardControler.randomShipsCoordinates(gameBoardSize);
    }

    public GameBoardController getGameBoardControler() {
        return gameBoardControler;
    }

    public void setGameBoardControler(GameBoardController gameBoardController) {
        this.gameBoardControler = gameBoardController;
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
