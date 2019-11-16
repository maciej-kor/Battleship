package Model.gui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() {

        setLayout(null);
        BoardPanel boardPanel1 = new BoardPanel();
        boardPanel1.setSize(boardPanel1.getPreferredSize());
        boardPanel1.setBounds(40, 120, boardPanel1.getPreferredSize().width, boardPanel1.getPreferredSize().height);
        this.add(boardPanel1);
        this.setBackground(Color.white);

        BoardPanel boardPanel2 = new BoardPanel();
        boardPanel2.setSize(boardPanel2.getPreferredSize());
        boardPanel2.setBounds(680, 120, boardPanel2.getPreferredSize().width, boardPanel2.getPreferredSize().height);
        this.add(boardPanel2);


        JButton start = new JButton();
        start.setBounds(585, 50, 150, 50);
        start.setText("Zaczynamy!");
        this.add(start);

    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1320, 760);
    }


}
