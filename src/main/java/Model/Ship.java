package Model;

import java.util.List;
import java.util.Random;

public class Ship {

    private int length = 1;
    private int hitsNumber = 0;
    private boolean isSunken = false;
    private int coordinates[][];


    public Ship(int lenght, int boardSize) {
        this.setLength(lenght);
        coordinates = new int[length][3];
        setRandomCoordinates(length, boardSize-1, GameBoard.shipList);
        GameBoard.shipList.add(this);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 0 && length <= 4) {
            this.length = length;
        } else {
            System.out.println("Ship length must be between 1 and 4");
        }
    }

    public int getHitsNumber() {
        return hitsNumber;
    }

    public void setHitsNumber(int hitsNumber) {
        this.hitsNumber = hitsNumber;
    }

    public boolean isSunken() {
        return isSunken;
    }

    public void setSunken(boolean sunken) {
        isSunken = sunken;
    }

    public int[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[][] coordinates) {
        this.coordinates = coordinates;
    }

    public void setRandomCoordinates(int length, int boardSize, List<Ship> ships) {

        int x = 0;
        int y = 0;
        int i = 0;
        boolean direction = false;

        while (i < length) {

            if (i == 0) {
                x = (int) (Math.random() * (boardSize + 1));
                y = (int) (Math.random() * (boardSize + 1));
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


            if (cordinateIsCorrect(x, y, length, boardSize, ships)) {

                coordinates[i][0] = y;
                coordinates[i][1] = x;
                coordinates[i][2] = 1;

                i++;

            } else if (length > 1)
                i = 0;
        }

    }

    public boolean cordinateIsCorrect(int x, int y, int lenght, int boardSize, List<Ship> ships) {

        if (ships.isEmpty())
            return true;

        if (x < 0 || y < 0 || x > boardSize || y > boardSize)
            return false;

        for (Ship ship : ships) {

            for (int i = 0; i < lenght; i++) {

                int tmpY = ship.coordinates[i][0];
                int tmpX = ship.coordinates[i][1];

                if ((tmpY == y - 1 || tmpY == y || tmpY == y + 1) && (tmpX == x - 1 || tmpX == x || tmpX == x + 1))
                    return false;
            }

        }

        return true;
    }

}
