package Model;

import java.util.List;

public interface GameBoardController {

    void addFields(int gameBoardSize);

    void randomShipsCoordinates(int gameBoardSize);

    void shot(int x, int y);

    int getShipwreckNumber();

    List<Field> getFields();

    int getFieldStatus(int x, int y, Player player);



}
