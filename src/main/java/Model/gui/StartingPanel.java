package Model.gui;

import Model.controller.Controller;

import javax.swing.*;
import java.awt.*;
public class StartingPanel extends JPanel {

    private JTextField player1Name, player2Name;
    private NextButton nextButton = new NextButton();
    private JLabel player1, player2, inputNames;
    Controller controller;

    public StartingPanel(Controller controller) {
        setLayout(null);
        this.controller = controller;

        //setting background
        ImageIcon img = new ImageIcon("Background.jpg");
        JLabel background = new JLabel(img, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);

        //setting nextButtonAction
        createJButtons();
        add(nextButton);

        //setting JTextFields
        createJTextFields();
        add(player1Name);
        add(player2Name);

        //setting JLabels
        createJLabels();
        add(player1);
        add(player2);
        add(inputNames);

        //Tło trzeba dodawać na końcu, bo inaczej się gryzie z elementami
        add(background);

    }

    public void createJLabels() {

        player1 = new JLabel();
        player1.setText("Player 1: ");
        player1.setFont(new Font("Arial", Font.BOLD, 15));
        player1.setBounds(600, 125, 100, 30);

        player2 = new JLabel();
        player2.setText("Player 2: ");
        player2.setFont(new Font("Arial", Font.BOLD, 15));
        player2.setBounds(600, 200, 100, 30);

        inputNames = new JLabel();
        inputNames.setText("Input your names soldiers!");
        inputNames.setFont(new Font("Arial", Font.BOLD, 50));
        inputNames.setBounds(400, 50, 800, 80);
    }

    public void createJButtons() {

        nextButton = new NextButton();
        nextButton.setBounds(850, 150, 90, 90);
        nextButton.setIcon(NextButton.nextButtonImg);
        nextButton.addActionListener(e -> {
            addUsers();
        });
    }

    public void createJTextFields() {
        player1Name = new JTextField();
        player1Name.setBounds(600, 150, 100, 25);

        player2Name = new JTextField();
        player2Name.setBounds(600, 225, 100, 25);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

    public void addUsers() {

        if (player1Name.getText().equals("") || player2Name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "I said input your name soldier! Listen to your commander or leave this ship!");
        } else {
            controller.addUser(player1Name.getText(), player2Name.getText());
        }
    }

}
