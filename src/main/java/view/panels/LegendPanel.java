package view.panels;

import controller.Controller;
import view.buttons.ExitButton;
import view.buttons.NextButton;

import javax.swing.*;
import java.awt.*;

public class LegendPanel extends JPanel{

    private static ImageIcon imageIconWater;
    private static ImageIcon imageIconEntered;
    private static ImageIcon imageIconMissedShot;
    private static ImageIcon imageIconHit;
    private static ImageIcon imageIconWreck;
    private static ImageIcon backgroundLegendPanel;

    private JLabel legendText, waterButton, waterButtonLegend,
            missedShotButton, missedShotButtonLegend, hitButton,
            hitButtonLegend, wreckButton, wreckButtonLegend, background;

    private NextButton nextButton;

    private Controller controller;


    public LegendPanel(Controller controller) {

        this.controller = controller;
        this.setLayout(null);
        addIcons();

        ExitButton exitButton = new ExitButton();
        exitButton.setBounds(100, 550, 180, 64);
        exitButton.addActionListener(e -> controller.closeApplication());
        this.add(exitButton);
        nextButton = new NextButton();
        nextButton.addActionListener(e -> controller.displayLoginWindow());
        nextButton.setBounds(1050,550, 180, 64);
        nextButton.setOpaque(false);
        this.add(nextButton);

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
        missedShotButtonLegend.setText("- This field means you missed a change");
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

        ImageIcon imageIconBackgroundLegendPanel1 = new ImageIcon(getClass().getResource("legendPanel.png"));
        Image imageBackgroundLegendPanel = imageIconBackgroundLegendPanel1.getImage();
        backgroundLegendPanel = new ImageIcon(imageBackgroundLegendPanel.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH));

        ImageIcon imageIconWater1 = new ImageIcon(getClass().getResource("water.png"));
        Image imageWater = imageIconWater1.getImage();
        imageIconWater = new ImageIcon(imageWater.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconEntered1 = new ImageIcon(getClass().getResource("selectField.png"));
        Image imageEntered = imageIconEntered1.getImage();
        imageIconEntered = new ImageIcon(imageEntered.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconMissedShot1 = new ImageIcon(getClass().getResource("missedShot.png"));
        Image imageMissedShot = imageIconMissedShot1.getImage();
        imageIconMissedShot = new ImageIcon(imageMissedShot.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHit1 = new ImageIcon(getClass().getResource("hit.png"));
        Image imageHit = imageIconHit1.getImage();
        imageIconHit = new ImageIcon(imageHit.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        ImageIcon imageIconHit12 = new ImageIcon(getClass().getResource("wreck.png"));
        Image imageHit1 = imageIconHit12.getImage();
        imageIconWreck = new ImageIcon(imageHit1.getScaledInstance(60, 60, Image.SCALE_DEFAULT));

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }
}
