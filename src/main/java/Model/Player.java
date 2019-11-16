package Model;

public class Player {

    private String name;
    protected static int wins = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getWins() {
        return wins;
    }

    public static void setWins(int wins) {
        Player.wins = wins;
    }
}
