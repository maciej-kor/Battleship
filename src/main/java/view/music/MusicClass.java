package view.music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicClass {

    private Clip clip;
    private Clip shot;
    private Clip hit;
    private Clip miss;
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

    public void playShotClip(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("shot.wav"));
            shot = AudioSystem.getClip();
            shot.open(audioInputStream);
            shot.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void playHitClip(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("shotHit.wav"));
            hit = AudioSystem.getClip();
            hit.open(audioInputStream);
            hit.start();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void playMissClip(){
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("shotMiss.wav"));
            miss = AudioSystem.getClip();
            miss.open(audioInputStream);
            miss.start();
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
