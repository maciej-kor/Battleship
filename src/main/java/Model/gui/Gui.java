package Model.gui;

public class Gui {

    GuiController guiController = new GuiController();

    public Gui(){
        guiController.addStartPanel();

        String filePath = "theme.wav";
        MusicClass musicObject = new MusicClass();
        musicObject.playMusic(filePath);
    }

}
