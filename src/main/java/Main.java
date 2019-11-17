import Model.Game;
import Model.GameBoard;
import Model.GameControler;
import Model.gui.MainFrame;

import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        GameControler gameControler = new Game();
//        gameControler.addPlayer("player1");
//        gameControler.getGameBoards();
//
//        List<GameBoard> fields = gameControler.getGameBoards();
//
//        gameControler.checkIfWin(fields.get(0));
        EventQueue.invokeLater(() -> new MainFrame());
           // MainFrame mainFrame = new MainFrame();


    }
}
