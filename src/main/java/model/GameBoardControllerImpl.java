package model;

import view.music.MusicClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoardControllerImpl implements GameBoardControllerInterface {


    private List<Ship> shipList;
    private List<Field> fields;
    private MusicClass musicClass = new MusicClass();

    //Zapełnia listę pól obiektami Field z przypisanymi współrzędnymi
    //Ustawia stany wszystkich pól na "EMPTY"
    @Override
    public void addFields(int gameBoardSize) {

        fields = new ArrayList<>();

        for (int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {

                Field field = new Field();

                field.setXx(j);
                field.setYy(i);
                field.setFieldState(FieldState.EMPTY);

                fields.add(field);

            }
        }
    }

    //Wywołuje metodę randomShipCoordinates(int shipsNumber, int shipsLength, int gameBoardSize)
    @Override
    public void randomShipsCoordinates(int gameBoardSize) {

        shipList = new ArrayList<>();

        randomShipCoordinates(0, 1, gameBoardSize);
        randomShipCoordinates(0, 2, gameBoardSize);
        randomShipCoordinates(0, 3, gameBoardSize);
        randomShipCoordinates(1, 4, gameBoardSize);

    }

    //Właściwa metoda strzału - iteruje po liście statków porównując koordynaty przypisane do obiektu
    //z tymi podanymi w parametrze. Sprawdza czy statek został zatopiony oraz zwraca flagę trafienia
    //potrzebną do ustalenia kolejnego ruchu graczy.
    //Dodatkowo metoda ustawia nowe statusy obiektów typu Field
    @Override
    public boolean changeStateOfSelectedField(int x, int y) {

        boolean hit = false;

        for (Ship ship : shipList) {

            for (int j = 0; j < ship.getLength(); j++) {

                int[][] cord = ship.getCoordinates();

                int yShip = cord[j][0];
                int xShip = cord[j][1];

                if (yShip == y && xShip == x) {
                    ship.setHitsNumber(ship.getHitsNumber() + 1);

                    for (Field field : fields) {

                        if (field.getXx() == x && field.getYy() == y) {

                            field.setFieldState(FieldState.HIT);
                            musicClass.playHitClip();
                            hit = true;

                        }

                        if (ship.getHitsNumber() == ship.getLength()) {
                            ship.setSunken(true);
                            sank(ship);

                        }
                    }
                }
            }
        }

        if (!hit) {

            musicClass.playMissClip();

            for (Field field : fields) {

                if (field.getXx() == x && field.getYy() == y)
                    field.setFieldState(FieldState.MISSED_SHOT);

            }
        }

        return hit;

    }


    private void sank(Ship ship) {

        for (int i = 0; i < ship.getLength(); i++) {

            for (Field field : fields) {

                if (field.getYy() == ship.getCoordinates()[i][0] && field.getXx() == ship.getCoordinates()[i][1])
                    field.setFieldState(FieldState.WRECK);

            }
        }
    }

    //Metoda zliczająca zestrzelone statki na podstawie flagi zatopienia
    //będącej polem obiektu klasy Ship
    @Override
    public int getShipwreckNumber() {
        int shipWreckNumber = 0;

        for (Ship ship : shipList) {
            if (ship.isSunken())
                shipWreckNumber++;
        }

        return shipWreckNumber;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    @Override
    public List<Field> getFields() {
        return fields;
    }

    //Metoda generuje nam losowe koordynaty jednego statku
    private void randomShipCoordinates(int shipsNumber, int shipsLenght, int gameBoardSize) {

        for (int i = 0; i < shipsNumber; i++) {

            int currentShipListSize = shipList.size();
            int j = currentShipListSize;

            while (j < currentShipListSize + 1) {

                Ship ship;

                int randomCoordinates[][] = randomCoordinate(shipsLenght, gameBoardSize);

                ship = addShip(randomCoordinates, shipsLenght, gameBoardSize);

                if (ship != null) {
                    shipList.add(ship);
                    j++;
                }

            }

        }

    }

    //Metoda zwraca nam status żądanego obiektu klasu Field
    public int getFieldStatus(int x, int y, Player player) {

        final int EMPTY_FIELD = 0;
        final int MISSED_SHOT = -1;
        final int HIT = 1;
        final int WRECK = 2;

        for (Field f : fields) {
            if (x == f.getXx() && y == f.getYy()) {

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

