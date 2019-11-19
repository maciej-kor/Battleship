package Model.gui;

import Model.controller.Controller;

public class Gui {

    StartingPanel startingPanel;
    MainFrame mainFrame;
    Controller controller;
    MainPanel mainPanel;

    public Gui(Controller controller) {

        this.controller = controller;
        String filePath = "theme.wav";
        MusicClass musicObject = new MusicClass();
        musicObject.playMusic(filePath);

        addFrame();
        addStartPanel();

    }

    public void addFrame() {
        mainFrame = new MainFrame();
    }

    public void addStartPanel() {
        startingPanel = new StartingPanel(controller);
        startingPanel.setVisible(true);
        mainFrame.add(startingPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();
    }

    public void createGamePanel(){
        mainFrame.setVisible(false);
        MainFrame mainFrame = new MainFrame();

        mainPanel = new MainPanel(controller);

        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setWindowInCenter();
        mainPanel.setVisible(true);

    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
