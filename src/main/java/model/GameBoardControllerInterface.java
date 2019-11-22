package model;

import java.util.List;

public interface GameBoardControllerInterface {

    void addFields(int gameBoardSize);

    void randomShipsCoordinates(int gameBoardSize);

    boolean changeStateOfSelectedField(int x, int y);

    int getShipwreckNumber();

    List<Field> getFields();

    int getFieldStatus(int x, int y, Player player);

    List<Ship> getShipList();



}
