package Model.controller;

import Model.*;
import Model.gui.Gui;

import java.util.List;
import java.util.Random;

public class Controller {

    GameControler gameControler = new Game();
    Gui gui;
    public static List<Player> playerList;
    Player ktoryGraczMaRuch;

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

            if (whoStart) {
                ktoryGraczMaRuch = gameControler.getPlayers().get(0);
            } else {
                ktoryGraczMaRuch = gameControler.getPlayers().get(1);
            }

            legendPanel();

        }

    }

    public void legendPanel(){

        gui.createLegendPanel();

    }

    public void oknoLosowania() {

        Player player = playerList.get(0);

        gui.createRandomPanel(player);

    }

    public void oknoLosowania(Player player) {

        gui.createRandomPanel(player);

    }


    public void zacznijRozgrywke() {

        gui.createGamePanel();

    }

    public void closeWindows(){
        gui.getMainFrame().dispose();
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

    public Player zwrocGraczaKtoregoRuchJest() {
        return ktoryGraczMaRuch;
    }

    public List<GameBoard> getGameBoardList() {
        return gameControler.getGameBoards();
    }

    public void shoot(Player player, int x, int y) {

        gameControler.shot(x, y, player);

        aktualizujStatusPol(player);

        if (gameControler.checkIfWin(player)){

            gui.wyswietlPanelZwyciestwa(player);

        }

        for (Player p : playerList) {
            if (p.isNextMove()) {
                p.setNextMove(true);
                setKtoryGraczMaRuch(p);
               // gui.usunMgielke(p);
            } else {
                p.setNextMove(false);
                //gui.dodajMgielke(p);
            }
        }

    }

    public void aktualizujStatusPol(Player player) {

        int[][] fieldStates = gameControler.getFieldsState(player);

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                int tmpStatus = fieldStates[j][i];

                gui.getMainPanel().getBoardPanelList(player).getjButtons()[i][j].setStatus(tmpStatus);
            }
        }

        gui.getMainPanel().getBoardPanelList(player).rysujIkony(10);

    }

    public Player getKtoryGraczMaRuch() {
        return ktoryGraczMaRuch;
    }

    public void setKtoryGraczMaRuch(Player ktoryGraczMaRuch) {
        this.ktoryGraczMaRuch = ktoryGraczMaRuch;
    }
}

