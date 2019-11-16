package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoardControlerImpl implements GameBoardController {


    public static List<Ship> shipList = new ArrayList<>();
    public static List<Field> gameBoards = new ArrayList<>();

    @Override
    public void addGameBoard(int gameBoardSize) {

        for (int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {

                Field field = new Field();

                field.setX(j);
                field.setY(i);
                field.setFieldState(FieldState.EMPTY);

                gameBoards.add(field);

            }
        }

    }

    @Override
    public void randomShipsCoordinates(int gameBoardSize) {

        randomShipCoordinates(1, 1, gameBoardSize);
        randomShipCoordinates(2, 2, gameBoardSize);
        randomShipCoordinates(1, 3, gameBoardSize);
        randomShipCoordinates(1, 4, gameBoardSize);

        System.out.println(shipList);
    }

    @Override
    public void shot(int x, int y) {

        for (Ship ship : shipList) {
            for (int i = 0; i < ship.getLength(); i++) {

                if (ship.getCoordinates()[i][0] == x && ship.getCoordinates()[i][1] == y) {

                    ship.setHitsNumber(ship.getHitsNumber() + 1);

                    if (ship.getHitsNumber() == ship.getLength())
                        ship.setSunken(true);

                    for (Field field : gameBoards) {

                        if (field.getX() == x && field.getY() == y)
                            field.setFieldState(FieldState.HIT);

                    }

                } else {

                    for (Field field : gameBoards) {

                        if (field.getX() == x && field.getY() == y)
                            field.setFieldState(FieldState.MISSED_SHOT);

                    }
                }
            }
        }


    }


    public void randomShipCoordinates(int shipsNumber, int shipsLenght, int gameBoardSize) {

        for (int i = 0; i < shipsNumber; i++) {

            int currentShipListSize = shipList.size();
            int j = currentShipListSize;

            while (j < currentShipListSize + 1) {

                Ship ship;

                int randomCoordinates[][] = randomCoordinate(shipsLenght, gameBoardSize);

                ship = addShip(randomCoordinates, shipsLenght, gameBoardSize);

                if (ship != null) {
                    shipList.add(addShip(randomCoordinates, shipsLenght, gameBoardSize));
                    j++;
                }

            }

            System.out.println(shipList);

        }

    }

    private int[][] randomCoordinate(int shipLenght, int gameBoardSize) {

        int x = 0, y = 0, i = 0;
        boolean direction = false;
        int[][] coordinates = new int[shipLenght][2];

        while (i < shipLenght) {

            if (i == 0) {

                x = (int) (Math.random() * (gameBoardSize));
                y = (int) (Math.random() * (gameBoardSize));

            } else if (i == 1) {

                Random random = new Random();
                direction = random.nextBoolean();

                if (direction)
                    x++;
                else
                    y++;

            } else if (direction)
                x++;
            else
                y++;

            coordinates[i][0] = x;
            coordinates[i][1] = y;
            i++;

        }

        return coordinates;
    }

    private Ship addShip(int[][] coordinates, int lenght, int gameBoardSize) {

        int x, y;
        int i = 0;

        Ship ship = new Ship();
        ship.setLength(lenght);
        ship.setCoordinates(coordinates);

        while (i < lenght) {

            x = coordinates[i][0];
            y = coordinates[i][1];

            if (x < 0 || y < 0 || x > gameBoardSize - 1 || y > gameBoardSize - 1)
                return null;

            if (!shipList.isEmpty()) {

                for (Ship s : shipList) {

                    for (int j = 0; j < s.getLength(); j++) {

                        int tmpY = s.getCoordinates()[j][1];
                        int tmpX = s.getCoordinates()[j][0];

                        if ((tmpY == y - 1 || tmpY == y || tmpY == y + 1) && (tmpX == x - 1 || tmpX == x || tmpX == x + 1))
                            return null;
                    }
                }
            }

            i++;

        }
        return ship;
    }

}

