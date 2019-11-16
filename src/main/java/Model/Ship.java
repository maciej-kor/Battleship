package Model;

public class Ship {

    private int length;
    private int hitsNumber = 0;
    private boolean isSunken = false;
    private int coordinates[][];


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

}
