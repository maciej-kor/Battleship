package Model.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButton extends JButton {

    public static ImageIcon nextButtonImg;

    public NextButton(){
        this.setContentAreaFilled(false);
        this.setIcon(nextButtonImg);
        this.setBorder(null);
        addIcon();

        //Listenera twórz lepiej bezpośrednio w Panelu

//        this.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                MainFrame.startingPanel.setVisible(false);
//                MainFrame.mainPanel = new MainPanel();
//            }
//        });
    }

    public void addIcon(){
        ImageIcon nextButtonImage = new ImageIcon(getClass().getResource("nextButton.png"));
        Image imageNextButton = nextButtonImage.getImage();
        nextButtonImg = new ImageIcon(imageNextButton.getScaledInstance(90, 90, Image.SCALE_AREA_AVERAGING));
    }

}
