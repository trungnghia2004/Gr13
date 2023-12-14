package project.playgame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DaoDien extends JFrame implements ActionListener {
    JButton start;
    JButton huong;
    JButton exit;
    JLabel bk;

   public DaoDien() {

        this.setTitle("Escape the dungeon");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 853);
        this.setResizable(false);

        ImageIcon logo = new ImageIcon("src\\project\\imag\\logo.png");

      //  ImageIcon logo = new ImageIcon("src\\project\\project.test2\\imag");

        this.getContentPane().setBackground(Color.black);
        this.setIconImage(logo.getImage());
        ImageIcon iconBk = new ImageIcon("src\\project\\imag\\.png");
        bk = new JLabel("",iconBk,JLabel.CENTER);
        add(bk);
        this.setLocationRelativeTo(null);

        this.setVisible(true);


        start = new JButton();
        start.setBounds(540, 100, 200, 100);
        start.setBorderPainted(false);
        start.setContentAreaFilled(false);


        start = new JButton();
        start.setBounds(540, 100, 200, 100);
        start.setText("START");
        start.setFont(new Font("Comic Sans", Font.BOLD, 20));
        start.setForeground(Color.red);
        start.setBorderPainted(false);
        start.setContentAreaFilled(false);
        start.addActionListener(this);

        bk.add(start);

        huong = new JButton();
        huong.setBounds(540, 200, 200, 100);
        huong.setText("HOW TO PLAY");
        huong.setFont(new Font("Comic Sans", Font.BOLD, 20));
        huong.setForeground(Color.red);
        huong.setBorderPainted(false);
        huong.setContentAreaFilled(false);
       bk.add(huong);

        exit = new JButton();
        exit.setBounds(540, 300, 200, 100);
        exit = new JButton();
        exit.setBounds(540, 300, 200, 100);
        exit.setText("EXIT");
        exit.setFont(new Font("Comic Sans", Font.BOLD, 25));
        exit.setForeground(Color.red);

        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(this);
        bk.add(exit);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            new LeverGame();
            this.setVisible(false);
        }
        if (e.getSource() == huong) {

        }
        if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
