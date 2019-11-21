package Model.gui;

import Model.Player;

import javax.swing.*;
import java.awt.*;

public class WinnerPanel extends JPanel {

    public WinnerPanel(Player player){

        setLayout(null);

        ImageIcon img = new ImageIcon("Background.jpg");
        JLabel background = new JLabel(img, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);

        ImageIcon img1 = new ImageIcon(getClass().getResource("mg.png"));

        JLabel background1 = new JLabel(img1, JLabel.CENTER);
        background1.setBounds(0, 0, 1280, 720);


        JLabel nameOfTheWinner = new JLabel();
        nameOfTheWinner.setBounds(0, 0, 200, 40);
        nameOfTheWinner.setFont(new Font("Arial", Font.BOLD, 50));
        nameOfTheWinner.setText(player.getName());

        add(nameOfTheWinner);
        add(background);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

}
