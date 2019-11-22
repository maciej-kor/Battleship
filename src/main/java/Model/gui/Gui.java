package Model.gui;

import Model.Player;
import Model.controller.Controller;

public class Gui {

    StartingPanel startingPanel;
    MainFrame mainFrame;
    Controller controller;
    MainPanel mainPanel;
    RandomShipsPanel randomShipsPanel;

    public Gui(Controller controller) {

        this.controller = controller;
//        String filePath = "theme.wav";
//        MusicClass musicObject = new MusicClass();
//        musicObject.playMusic(filePath);

        addFrame();
        createStartPanel();

    }

    public void addFrame() {
        mainFrame = new MainFrame();
    }

    public void createStartPanel() {

        startingPanel = new StartingPanel(controller);
        startingPanel.setVisible(true);
        mainFrame.add(startingPanel);
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

    public void wyswietlPanelZwyciestwa(Player player) {

        mainFrame.setVisible(false);
        mainFrame = new MainFrame();
        WinnerPanel winnerPanel = new WinnerPanel(player);
        winnerPanel.setVisible(true);
        mainFrame.add(winnerPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();

    }



//    public void dodajMgielke(Player player) {
//
//        mainPanel.getBoardPanelList(player).zakryj();
//
//    }
//
//    public void usunMgielke(Player player) {
//
//        mainPanel.getBoardPanelList(player).odkryj();
//
//    }


    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public RandomShipsPanel getRandomShipsPanel() {
        return randomShipsPanel;
    }

    public void setRandomShipsPanel(RandomShipsPanel randomShipsPanel) {
        this.randomShipsPanel = randomShipsPanel;
    }
}
