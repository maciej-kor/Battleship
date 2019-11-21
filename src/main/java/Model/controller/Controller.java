package Model.controller;

import Model.*;
import Model.gui.FieldButton;
import Model.gui.Gui;

import java.util.List;
import java.util.Random;

public class Controller {

    GameControler gameControler = new Game();
    Gui gui;
    public static List<Player> playerList;
    public static int kolejnoscGraczy = 0;

    public Controller() {

        gui = new Gui(this);
    }

    public void addUser(String name1, String name2) {

        gameControler.addPlayer(name1);
        gameControler.addPlayer(name2);

        playerList = gameControler.getPlayers();

        if (sprawdzCzyJestDwochUzytkownikow()) {
            Random random = new Random();
            boolean whoStart = random.nextBoolean();

            if (whoStart){
                gameControler.getPlayers().get(0).setNextMove(true);
                gameControler.getPlayers().get(1).setNextMove(false);
                System.out.println("zaczyna: " + gameControler.getPlayers().get(0));
            } else {
                gameControler.getPlayers().get(1).setNextMove(true);
                gameControler.getPlayers().get(0).setNextMove(false);
                System.out.println("zaczyna: " + gameControler.getPlayers().get(1).getName());
            }

            gui.createGamePanel();
        }

    }

    public void oknoLosowania(Player player) {

        gui.createRandomPanel(player);

    }

    public void zacznijRozgrywke() {

        gui.createGamePanel();

    }

    public Ship[] losujStatki(Player player) {

        List<Ship> shipList = gameControler.losuj(player);

        Ship[] shipArray = new Ship[shipList.size()];

        for (int i = 0; i < shipList.size(); i++) {
            shipArray[i] = shipList.get(i);
        }

        return shipArray;

    }

    public boolean sprawdzCzyJestDwochUzytkownikow() {

        if (gameControler.getPlayers().size() == 0)
            return false;

        if (gameControler.getPlayers().size() > 1) {

            if (gameControler.getPlayers().size() == 2)
                return true;
            else
                return false;
        }

        return false;

    }

    public List<GameBoard> getGameBoardList() {
        return gameControler.getGameBoards();
    }

    public void shoot(Player player, int x, int y) {

        gameControler.shot(x, y, player);

        aktualizujStatusPol(player);

        zamglijPole(player);

    }

    public void zamglijPole(Player player) {

        if (kolejnoscGraczy % 2 == 0) {
            //gui.zamglij(player);
            kolejnoscGraczy++;
        }

    }

    public void aktualizujStatusPol(Player player) {

        int[][] fieldStates = gameControler.getFieldsState(player);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int tmpStatus = fieldStates[j][i];

                gui.getMainPanel().getBoardPanel(player).getjButtons()[i][j].setStatus(tmpStatus);
            }
        }

        gui.getMainPanel().getBoardPanel(player).rysujIkony(10);
    }


}

