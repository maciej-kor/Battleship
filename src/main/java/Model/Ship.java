package Model;

public class Ship {

    private int id;
    private int gridNumber;
    private int length = 1;
    private int hitsNumber = 0;
    private boolean isSunken = false;
    private int coordinates[][] = new int[length][2];

    public Ship(int id, int gridNumber, int length, int[][] coordinates) {
        this.setId(id);
        this.setGridNumber(gridNumber);
        this.setLength(length);
        this.setCoordinates(coordinates);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0 && id <= 20) {
            this.id = id;
        } else {
            System.out.println("You have reached ship limit");
        }
    }

    public int getGridNumber() {
        return gridNumber;
    }

    public void setGridNumber(int gridNumber) {
        this.gridNumber = gridNumber;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 0 && length <= 4) {
            this.length = length;
        }else {
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
}
