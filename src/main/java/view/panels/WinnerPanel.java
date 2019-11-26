package view.panels;

import controller.Controller;
import model.Player;
import view.buttons.ExitButton;
import view.buttons.NewGameButton;

import javax.swing.*;
import java.awt.*;

public class WinnerPanel extends JPanel {

    private Controller controller;


    public WinnerPanel(Player player, Controller controller) {

        this.controller = controller;

        setLayout(null);

        ImageIcon img = new ImageIcon(getClass().getResource("backgroundWinnerPanel.png"));
        JLabel background = new JLabel(img, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);

        JLabel text = new JLabel();
        text.setBounds(500, 200, 300, 60);
        text.setFont(new Font("Arial", Font.BOLD, 40));
        text.setText("Congratulation");

        JLabel nameOfTheWinner = new JLabel();
        nameOfTheWinner.setBounds(550, 300, 200, 50);
        nameOfTheWinner.setFont(new Font("Arial", Font.BOLD, 40));
        nameOfTheWinner.setText(player.getName());

        NewGameButton newGameButton = new NewGameButton();
        newGameButton.setBounds(780, 530, 180, 64);
        add(newGameButton);

        ExitButton exitButton = new ExitButton();
        exitButton.setBounds(320, 530, 180, 64);
        add(exitButton);

        newGameButton.addActionListener(e -> controller.startNewGame());
        exitButton.addActionListener(e -> controller.closeApplication());

        add(text);
        add(nameOfTheWinner);
        add(background);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

}
