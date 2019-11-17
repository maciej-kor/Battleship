package Model.gui;

import Model.*;

import java.util.List;

public class GuiController {

    GameControler game = new Game();

    public void addUser(String firstNickName, String secondNickName) {
        if (firstNickName.equals(secondNickName)) {
            System.out.println("BŁĄD: nicki takie same");
        } else {
            game.addPlayer(firstNickName);
            game.addPlayer(secondNickName);
        }
    }

    public void randomCoordinates(Player player) {
        List<GameBoard> gameBoards = game.getGameBoards();

        for (GameBoard o : gameBoards) {
            if (o.getPlayer().getName().equals(player.getName())) {
                o.randomShipCoordinates();
            }
        }
    }

    public void shoot(int x, int y, Player player) {

        game.shot(x, y, player);

    }

    public int loadFieldState(int x, int y, Player player) {

        final int EMPTY_FIELD = 0;
        final int MISSED_SHOT = -1;
        final int HIT = 1;
        final int WRECK = 2;

        List<Field> fields = game.getGameBoard(player).getGameBoardControler().getFields();

        for (Field f : fields) {
            if (x == f.getX() && y == f.getY()) {
                f.getFieldState();
                if (f.getFieldState().equals(FieldState.EMPTY)) {
                    return EMPTY_FIELD;
                } else if (f.getFieldState().equals(FieldState.HIT)) {
                    return HIT;
                } else if (f.getFieldState().equals(FieldState.MISSED_SHOT)) {
                    return MISSED_SHOT;
                } else if (f.getFieldState().equals(FieldState.WRECK)) {
                    return WRECK;
                }
            }
        }
        return -2;
    }


}
