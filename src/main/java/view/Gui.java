package view;

import model.Player;
import controller.Controller;
import view.panels.*;
import view.music.*;

public class Gui {

    StartPanel startPanel;
    MainFrame mainFrame;
    Controller controller;
    MainPanel mainPanel;
    RandomShipsPanel randomShipsPanel;

    public Gui(Controller controller) {

        this.controller = controller;

        MusicClass musicObject = new MusicClass();
        musicObject.playMusic();

        addFrame();
        createStartPanel();

    }

    public void addFrame() {
        mainFrame = new MainFrame();
    }

    public void createStartPanel() {

        startPanel = new StartPanel(controller);
        startPanel.setVisible(true);
        mainFrame.add(startPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();

    }

    public void createLegendPanel(){

        mainFrame.setVisible(false);
        mainFrame = new MainFrame();
        LegendPanel legendPanel = new LegendPanel(controller);
        legendPanel.setVisible(true);
        mainFrame.add(legendPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();

    }

    public void createRandomPanel(Player player) {

        mainFrame.setVisible(false);
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        randomShipsPanel = new RandomShipsPanel(controller, player);
        mainFrame.add(randomShipsPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();

    }

    public void createGamePanel() {

        mainFrame.setVisible(false);
        mainFrame = new MainFrame();
        mainPanel = new MainPanel(controller);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();

    }

    public void createWinnerPanel(Player player) {

        mainFrame.setVisible(false);
        mainFrame = new MainFrame();
        WinnerPanel winnerPanel = new WinnerPanel(player);
        winnerPanel.setVisible(true);
        mainFrame.add(winnerPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();

    }

    public void setFog(Player player){

        for (Player p : controller.playerList){

            if (!player.getName().equals(p.getName()))
                mainPanel.getBoardPanelList(p).setFogImageVisible();
             else
                mainPanel.getBoardPanelList(p).setFogImageInvisible();

        }

    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }


}
