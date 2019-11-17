package Model.gui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class MusicClass {

    void playMusic(String musicLocation){
        try{
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }else {
                System.out.println("Can't find file");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
