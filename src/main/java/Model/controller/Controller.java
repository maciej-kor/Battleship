package Model.controller;

import Model.*;
import Model.gui.BoardPanel;
import Model.gui.FieldButton;
import Model.gui.Gui;

import java.util.List;

public class Controller {

    GameControler gameControler = new Game();
    Gui gui;

    public Controller() {

        gui = new Gui(this);

    }

    public void addUser(String name) {
        gameControler.addPlayer(name);

        if (sprawdzCzyJestDwochUzytkownikow()) {
            gui.createGamePanel();
        }
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

        aktualizujStatusPola(player, x, y);

    }

    public void aktualizujStatusPola(Player player, int x, int y) {

        FieldButton[][] fieldButtonArray = gui.getMainPanel().getBoardPanel(player).getjButtons();

        int status = gameControler.getGameBoard(player).getGameBoardControler().getFieldStatus(x, y, player);

        gui.getMainPanel().getBoardPanel(player).getjButtons()[x][y].setStatus(status);

        System.out.println((gui.getMainPanel().getBoardPanel(player).getPlayer().getName()));

        int tmpStatus;
        if (status == 2) {
            for (int i = 0; i < fieldButtonArray.length; i++) {
                for (int j = 0; j < fieldButtonArray.length; j++) {

                    tmpStatus = gameControler.getGameBoard(player).getGameBoardControler().getFieldStatus(i, j, player);

                    if (tmpStatus == 2)
                        gui.getMainPanel().getBoardPanel(player).getjButtons()[i][j].setStatus(tmpStatus);

                }
            }
        }
        gui.getMainPanel().getBoardPanel(player).rysujIkony(10);

    }
}

