package project.test2;




import javax.swing.*;


public class Window  {

    public Window() {
        JFrame window = new JFrame("Escape the dungeon");
        GamePanel gamePanel = new GamePanel(window);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.setUpGame();
        gamePanel.startGameThread();

    }

}
