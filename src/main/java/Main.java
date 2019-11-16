import Model.GameBoardControlerImpl;

public class Main {
    public static void main(String[] args) {

        Model.GameBoardController gameBoardController = new GameBoardControlerImpl();
        gameBoardController.randomShipsCoordinates(7);

    }
}
