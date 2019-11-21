package Model.controller;

import Model.*;
import Model.gui.FieldButton;
import Model.gui.Gui;

import java.util.List;

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
            oknoLosowania(playerList.get(0));
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

