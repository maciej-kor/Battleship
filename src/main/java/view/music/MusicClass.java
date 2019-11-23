package view.music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicClass {

    private Clip clip;
    private long clipTimePosition;

    public void playMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("theme.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stopMusic(){
        System.out.println("stop");
        clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();
    }

    public void startMusic(){
        clip.setMicrosecondPosition(clipTimePosition);
        clip.start();
    }

}
