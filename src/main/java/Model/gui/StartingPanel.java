package Model.gui;

import Model.controller.Controller;

import javax.swing.*;
import java.awt.*;
public class StartingPanel extends JPanel {

    private JTextField player1Name, player2Name;
    private NextButton nextButton;
    private ExitButton exitButton;
    //private JLabel player1, player2, inputNames;
    Controller controller;
    Font fontTextField;

    public StartingPanel(Controller controller) {
        setLayout(null);
        this.controller = controller;

        //setting background
        ImageIcon img = new ImageIcon(getClass().getResource("backgroundStartingPanel.png"));
        JLabel background = new JLabel(img, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);

        //setting nextButtonAction
        createJButtons();
        add(nextButton);
        add(exitButton);

        //setting JTextFields
        createJTextFields();
        add(player1Name);
        add(player2Name);

        fontTextField = new Font("ARIAL", Font.BOLD, 12);

        add(background);

    }


    public void createJButtons() {

        nextButton = new NextButton();
        nextButton.setBounds(780, 530, 180, 65);
        nextButton.addActionListener(e -> {
            addUsers();
        });

        exitButton = new ExitButton();
        exitButton.setBounds(320, 530, 180, 65);
        exitButton.addActionListener(e->{exit();});


    }

    public void createJTextFields() {
        player1Name = new JTextField();
        player1Name.setBounds(530, 267, 200, 32);
        player1Name.setFont(fontTextField);

        player2Name = new JTextField();
        player2Name.setBounds(530, 380, 200, 32);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

    public void exit(){
        controller.closeWindows();
    }

    public void addUsers() {

        if (player1Name.getText().equals("") || player2Name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "I said input your name soldier! Listen to your commander or leave this ship!");
        } else {
            controller.addUser(player1Name.getText(), player2Name.getText());
        }
    }

}
