package view;

import model.Player;
import controller.Controller;
import view.panels.*;

public class Gui {

    private StartPanel startPanel;
    private MainFrame mainFrame;
    private Controller controller;
    private MainPanel mainPanel;
    private RandomShipsPanel randomShipsPanel;

    public Gui(Controller controller) {

        this.controller = controller;

        createStartPanel();

    }

    public void createStartPanel() {

        mainFrame = new MainFrame(controller);
        startPanel = new StartPanel(controller);
        startPanel.setVisible(true);
        mainFrame.add(startPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();

    }

    public void createLegendPanel(){

        mainFrame.setVisible(false);
        mainFrame = new MainFrame(controller);
        LegendPanel legendPanel = new LegendPanel(controller);
        legendPanel.setVisible(true);
        mainFrame.add(legendPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();

    }

    public void createRandomPanel(Player player) {

        mainFrame.setVisible(false);
        mainFrame = new MainFrame(controller);
        mainFrame.setVisible(true);
        randomShipsPanel = new RandomShipsPanel(controller, player);
        mainFrame.add(randomShipsPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();

    }

    public void createGamePanel() {

        mainFrame.setVisible(false);
        mainFrame = new MainFrame(controller);
        mainPanel = new MainPanel(controller);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();

    }

    public void createWinnerPanel(Player player) {

        mainFrame.setVisible(false);
        mainFrame = new MainFrame(controller);
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
