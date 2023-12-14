package project.playgame;

import project.test2.GamePanel;
import project.test2.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Again extends JFrame implements ActionListener {
    JButton exit;
    JButton again;
    JLabel over;

    public Again() {
        this.setSize(1280, 853);
        this.setResizable(false);
      //  ImageIcon logo = new ImageIcon("src\\project\\imag");
        this.getContentPane().setBackground(Color.black);
      //  this.setIconImage(logo.getImage());
        over = new JLabel("", JLabel.CENTER);

        add(over);
        this.setLocationRelativeTo(null);
        again = new JButton();
        again.setBounds(540, 100, 200, 100);
        again.setText("AGAIN");
        again.setFont(new Font("Comic Sans", Font.BOLD, 25));
        again.setForeground(Color.red);
        again.setBorderPainted(false);
        again.setContentAreaFilled(false);
        again.addActionListener(this);
        over.add(again);

        exit = new JButton();
        exit.setBounds(540, 200, 200, 100);
        exit.setText("EXIT");
        exit.setFont(new Font("Comic Sans", Font.BOLD, 25));
        exit.setForeground(Color.red);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(this);
        over.add(exit);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            new DaoDien();
            this.setVisible(false);
        }
        if (e.getSource() == again) {
            new Window();
            this.setVisible(false);
        }
    }
}
