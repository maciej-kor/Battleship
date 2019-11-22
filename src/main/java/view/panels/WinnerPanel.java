package view.panels;

import model.Player;

import javax.swing.*;
import java.awt.*;

public class WinnerPanel extends JPanel {

    public WinnerPanel(Player player){

        setLayout(null);

        ImageIcon img = new ImageIcon(getClass().getResource("background.jpg"));
        JLabel background = new JLabel(img, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);


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
