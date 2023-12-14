package project.playgame;


import project.test.MyFrame;
import project.test2.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeverGame extends JFrame implements ActionListener {
    JButton hard;
    JButton easy;
    JButton medium;
    JButton exit;
    JLabel bk;

    public LeverGame() {
        this.setSize(1280, 853);
        this.setResizable(false);
        ImageIcon logo = new ImageIcon("src\\project\\imag");
        this.getContentPane().setBackground(Color.black);
        this.setIconImage(logo.getImage());
        ImageIcon iconBk = new ImageIcon("src\\project\\imag\\");
        bk = new JLabel("", iconBk, JLabel.CENTER);
        add(bk);
        this.setLocationRelativeTo(null);

        hard = new JButton();
        hard.setBounds(540, 100, 200, 100);
        hard.setText("HARD");
        hard.setFont(new Font("Comic Sans", Font.BOLD, 25));
        hard.setForeground(Color.red);
        hard.setBorderPainted(false);
        hard.setContentAreaFilled(false);
        hard.addActionListener(this);
        bk.add(hard);

        medium = new JButton();
        medium.setBounds(540, 200, 200, 100);
        medium.setText("MEDIUM");
        medium.setFont(new Font("Comic Sans", Font.BOLD, 25));
        medium.setForeground(Color.red);
        medium.setBorderPainted(false);
        medium.setContentAreaFilled(false);
        medium.addActionListener(this);
        bk.add(medium);

        easy = new JButton();
        easy.setBounds(540, 300, 200, 100);
        easy.setText("EASY");
        easy.setFont(new Font("Comic Sans", Font.BOLD, 25));
        easy.setForeground(Color.red);
        easy.setBorderPainted(false);
        easy.setContentAreaFilled(false);
        easy.addActionListener(this);
        bk.add(easy);

        exit = new JButton();
        exit.setBounds(540, 400, 200, 100);
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
        if (e.getSource() == hard) {
            new Window();
            this.setVisible(false);
        }
        if (e.getSource() == medium) {
            new MyFrame();
            this.setVisible(false);
        }
        if (e.getSource() == easy) {

        }
        if (e.getSource() == exit) {
            new DaoDien();
            this.setVisible(false);
        }
    }
}
