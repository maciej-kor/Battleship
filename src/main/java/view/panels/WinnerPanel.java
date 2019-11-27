package view.panels;

import controller.Controller;
import model.Player;
import view.buttons.ExitButton;
import view.buttons.NewGameButton;

import javax.swing.*;
import java.awt.*;

public class WinnerPanel extends JPanel {

    public WinnerPanel(Player player, Controller controller) {

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
        newGameButton.setBounds(700, 530, 265, 64);
        add(newGameButton);

        ExitButton exitButton = new ExitButton();
        exitButton.setBounds(320, 530, 265, 64);
        add(exitButton);

        newGameButton.addActionListener(e -> controller.startNewGame());
        exitButton.addActionListener(e -> controller.closeApplication());

        add(text);
        add(nameOfTheWinner);

        ImageIcon img2 = new ImageIcon(getClass().getResource("baner.png"));
        Image imageBaner = img2.getImage();
        ImageIcon baner = new ImageIcon(imageBaner.getScaledInstance(510, 277, Image.SCALE_AREA_AVERAGING));
        JLabel banerLabel = new JLabel(baner);
        banerLabel.setBounds(0, -25, 1280,200 );
        add(banerLabel);

        add(background);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

}
