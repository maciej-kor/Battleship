package view.panels;

import controller.Controller;
import view.buttons.ExitButton;
import view.buttons.StartButton;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {

    private JTextField player1Name, player2Name;
    private StartButton startButton;
    private ExitButton exitButton;
    private Controller controller;
    private Font fontTextField;

    public StartPanel(Controller controller) {
        setLayout(null);
        this.controller = controller;

        //setting background
        ImageIcon img = new ImageIcon(getClass().getResource("backgroundStartingPanel.png"));
        JLabel background = new JLabel(img, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);

        //setting nextButtonAction
        createJButtons();
        add(startButton);
        add(exitButton);

        //setting JTextFields
        createJTextFields();
        add(player1Name);
        add(player2Name);

        add(background);

    }

    public void createJButtons() {

        startButton = new StartButton();
        startButton.setBounds(780, 530, 180, 64);
        startButton.addActionListener(e -> checkNickNamesCorrectness());

        exitButton = new ExitButton();
        exitButton.setBounds(320, 530, 180, 64);
        exitButton.addActionListener(e -> exit());

    }

    public void createJTextFields() {
        fontTextField = new Font("ARIAL", Font.PLAIN, 30);

        player1Name = new JTextField();
        player1Name.setBounds(530, 267, 200, 32);
        player1Name.setFont(fontTextField);

        player2Name = new JTextField();
        player2Name.setBounds(530, 380, 200, 32);
        player2Name.setFont(fontTextField);
    }

    private void exit() {
        controller.closeApplication();
    }

    private void addUsers() {

        controller.addUsers(player1Name.getText(), player2Name.getText());

    }

    public void checkNickNamesCorrectness() {

        if (player1Name.getText().equals("") || player2Name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "I said input your name soldier! Listen to your commander or leave this ship!");
        } else if (player1Name.getText().equals(player2Name.getText())) {
            JOptionPane.showMessageDialog(this, "You are not allowed to have the same names!");
            player1Name.setText("");
            player2Name.setText("");
        } else {
            addUsers();
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }


}
