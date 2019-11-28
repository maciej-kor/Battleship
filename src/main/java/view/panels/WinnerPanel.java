package view.panels;

import controller.Controller;
import model.Player;
import view.buttons.ExitButton;
import view.buttons.NewGameButton;

import javax.swing.*;
import java.awt.*;

public class WinnerPanel extends JPanel {

    int polozenieX = 0;
    int polozenieY = 250;
    int kierunekX = 3;

    public WinnerPanel(Player player, Controller controller) {

        setLayout(null);

        ImageIcon img = new ImageIcon(getClass().getResource("backgroundWinnerPanel.png"));
        JLabel background = new JLabel(img, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 720);

        //animacja();

        JLabel text = new JLabel();
        text.setBounds(500, 200, 350, 60);
        text.setFont(new Font("Arial", Font.BOLD, 40));
        text.setText("Congratulation!!!");

        JLabel nameOfTheWinner = new JLabel();
        nameOfTheWinner.setBounds(550, 300, 200, 50);
        nameOfTheWinner.setFont(new Font("Arial", Font.BOLD, 40));
        nameOfTheWinner.setText(player.getName().toUpperCase());

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

//        ImageIcon img3 = new ImageIcon(getClass().getResource("explosion1.gif"));
//        Image imageFirework = img3.getImage();
//        ImageIcon firework = new ImageIcon(imageFirework);
//        JLabel firework1 = new JLabel(firework);
//        firework1.setBounds(300, 400, 500, 474);
//        add(firework1);

        ImageIcon img3 = new ImageIcon(getClass().getResource("kbomba.png"));
        Image imageFire = img3.getImage();
        ImageIcon fire = new ImageIcon(imageFire);
        JLabel fire1 = new JLabel(fire);
        fire1.setBounds(750, 250, 190, 240);
        add(fire1);


        add(background);

    }

    public void animacja(){
        while (true){
            ruchAnimacji();
            repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void ruchAnimacji(){
        polozenieX = polozenieX + kierunekX;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        ImageIcon ptaki = new ImageIcon(getClass().getResource("birds.gif"));
        Image ptakiImg = ptaki.getImage();

        graphics2D.drawImage(ptakiImg, polozenieX, polozenieY, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

}
