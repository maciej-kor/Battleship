package Model.gui;

import Model.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LegendPanel extends JPanel{

    public static ImageIcon imageIconWater;
    public static ImageIcon imageIconEntered;
    public static ImageIcon imageIconMissedShot;
    public static ImageIcon imageIconHit;
    public static ImageIcon imageIconWreck;
    public static ImageIcon imageIconWaterFog;
    public static ImageIcon imageIconMissedShotFog;
    public static ImageIcon imageIconHitFog;
    public static ImageIcon imageIconWreckFog;
    public static ImageIcon backgroundLegendPanel;

    JLabel legendText, waterButton, waterButtonLegend,
            missedShotButton, missedShotButtonLegend, hitButton,
            hitButtonLegend, wreckButton, wreckButtonLegend, background;

    NextButton ok;

    Controller controller;


    public LegendPanel(Controller controller) {
        this.controller = controller;
        this.setLayout(null);
        addIcons();
        ok = new NextButton();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.oknoLosowania();
            }
        });
        ok.setBounds(1050,150, 90, 90);;
        this.add(ok);

        createJLabels();
    }

    public void createJLabels(){
        legendText = new JLabel();
        legendText.setText("Legend");
        legendText.setFont(new Font("Arial", Font.BOLD, 50));
        legendText.setBounds(285, 30, 500, 80);

        waterButton = new JLabel(imageIconWater);
        waterButton.setBounds(65, 100, 60,60);

        waterButtonLegend = new JLabel();
        waterButtonLegend.setText("- This field means water");
        waterButtonLegend.setFont(new Font("Arial", Font.BOLD, 25));
        waterButtonLegend.setBounds(150, 100, 500, 50);

        missedShotButton = new JLabel(imageIconMissedShot);
        missedShotButton.setBounds(65, 200, 60, 60);

        missedShotButtonLegend = new JLabel();
        missedShotButtonLegend.setText("- This field means you missed a shot");
        missedShotButtonLegend.setFont(new Font("Arial", Font.BOLD, 25));
        missedShotButtonLegend.setBounds(150, 200, 500, 50);

        hitButton = new JLabel(imageIconHit);
        hitButton.setBounds(65, 300, 60, 60);

        hitButtonLegend = new JLabel();
        hitButtonLegend.setText("- This field means you hit ship");
        hitButtonLegend.setFont(new Font("Arial", Font.BOLD, 25));
        hitButtonLegend.setBounds(150, 300, 500, 50);

        wreckButton = new JLabel(imageIconWreck);
        wreckButton.setBounds(65, 400, 60,60);

        wreckButtonLegend = new JLabel();
        wreckButtonLegend.setText("- This field means you sank ship");
        wreckButtonLegend.setFont(new Font("Arial", Font.BOLD, 25));
        wreckButtonLegend.setBounds(150, 400, 500, 50);

        background = new JLabel(backgroundLegendPanel, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);


        this.add(legendText);
        this.add(waterButton);
        this.add(waterButtonLegend);
        this.add(hitButton);
        this.add(hitButtonLegend);
        this.add(missedShotButton);
        this.add(missedShotButtonLegend);
        this.add(wreckButton);
        this.add(wreckButtonLegend);
        this.add(background);

    }

    public void addIcons() {

        ImageIcon imageIconBackgroundLegendPanel1 = new ImageIcon(getClass().getResource("legendpanel.png"));
        Image imageBackgroundLegendPanel = imageIconBackgroundLegendPanel1.getImage();
        backgroundLegendPanel = new ImageIcon(imageBackgroundLegendPanel.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH));

        ImageIcon imageIconWater1 = new ImageIcon(getClass().getResource("water.png"));
        Image imageWater = imageIconWater1.getImage();
        imageIconWater = new ImageIcon(imageWater.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconEntered1 = new ImageIcon(getClass().getResource("water2.png"));
        Image imageEntered = imageIconEntered1.getImage();
        imageIconEntered = new ImageIcon(imageEntered.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconMissedShot1 = new ImageIcon(getClass().getResource("missedShot.png"));
        Image imageMissedShot = imageIconMissedShot1.getImage();
        imageIconMissedShot = new ImageIcon(imageMissedShot.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHit1 = new ImageIcon(getClass().getResource("hit.png"));
        Image imageHit = imageIconHit1.getImage();
        imageIconHit = new ImageIcon(imageHit.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHit12 = new ImageIcon(getClass().getResource("missShot.png"));
        Image imageHit1 = imageIconHit12.getImage();
        imageIconWreck = new ImageIcon(imageHit1.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconWaterFog1 = new ImageIcon(getClass().getResource("waterDeactivated.png"));
        Image imageWaterFog = imageIconWaterFog1.getImage();
        imageIconWaterFog = new ImageIcon(imageWaterFog.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconMissedShotFog1 = new ImageIcon(getClass().getResource("missedShotDeactivated.png"));
        Image imageMissedShotFog = imageIconMissedShotFog1.getImage();
        imageIconMissedShotFog = new ImageIcon(imageMissedShotFog.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHitFog1 = new ImageIcon(getClass().getResource("hitDeactivated.png"));
        Image imageHitFog = imageIconHitFog1.getImage();
        imageIconHitFog = new ImageIcon(imageHitFog.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconWreckFog1 = new ImageIcon(getClass().getResource("missedShotDeactivated.png"));
        Image imageWreckFog = imageIconWreckFog1.getImage();
        imageIconWreckFog = new ImageIcon(imageWreckFog.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }
}
