package project.test;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class MyPanel extends JPanel implements ActionListener, KeyListener {
    int width;
    int height;
    int tileSize = 25;


    private class tile {
        int x;
        int y;
       Node dir;
        public tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    tile player;

    tile wolf;

    static class Node {
        int x, y;
        Node dir;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Timer timer;
    boolean gameOver = false;

    Stack<Node> stack;
    private final int[][] matrix = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    boolean[][] visited;
    int moved = 0;
    Stack<Node> newStack;
//    Image loli;
//    Image virus;
//    Image wall;
//    Image floor;
//    Image water;
//    Image door;
//    public void inputDataImage() {
//        loli = new ImageIcon("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\loli1.png").getImage();
//        virus = new ImageIcon("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\virus1.jpg").getImage();
//        wall = new ImageIcon("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\wall1.jpg").getImage();
//        floor = new ImageIcon("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\floor1.png").getImage();
//        water = new ImageIcon("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\water1.png").getImage();
////        door = new ImageIcon("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\virus1.jpg").getImage();
//    }

    MyPanel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.white);
        wolf = new tile(1, 11);
        player = new tile(1, 1);

//        inputDataImage();

        addKeyListener(this);
        setFocusable(true);

        timer = new Timer(1000, this);
        timer.start();
    }

    public void moveGhost() {
        if (wolf.x == player.x && wolf.y == player.y) {
            gameOver = true;
            return;
        }
        if (moved == 0 || moved == 1) {
            findPlayer();
            newStack = new Stack<>();
            while (!stack.isEmpty()) {
                newStack.push(stack.pop());
            }
            moved = 2;
        }
    }
    Queue<Node> queue = new LinkedList<>();
   Node temp;
    public void findPlayer() {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        queue.offer(new Node(wolf.x, wolf.y));
        visited[temp.x][temp.y] = true;
      Node newNode;
        while ((temp = queue.poll()) != null) {
            if (temp.x == wolf.x && temp.y == wolf.y) {
                queue = new LinkedList<>();
                break;
            }
            if (!visited[temp.x][temp.y - 1] &&
                    matrix[temp.x][temp.y - 1] != 1 &&
                    matrix[temp.x][temp.y - 1] != 4 &&
                    matrix[temp.x][temp.y - 1] != 5) {
                newNode = new Node(temp.x, temp.y - 1);
                newNode.dir = temp;
                visited[temp.x][temp.y - 1] = true;
                queue.offer(newNode);

            }
            if (!visited[temp.x][temp.y + 1] &&
                    matrix[temp.x][temp.y + 1] != 1 &&
                    matrix[temp.x][temp.y + 1] != 4 &&
                    matrix[temp.x][temp.y + 1] != 5) {
                newNode = new Node(temp.x, temp.y + 1);
                newNode.dir = temp;
                visited[temp.x][temp.y + 1] = true;

                queue.offer(newNode);
            }
            if (!visited[temp.x - 1][temp.y] &&
                    matrix[temp.x - 1][temp.y] != 1 &&
                    matrix[temp.x - 1][temp.y] != 4 &&
                    matrix[temp.x - 1][temp.y] != 5) {
                newNode = new Node(temp.x - 1, temp.y);
                newNode.dir = temp;
                visited[temp.x - 1][temp.y] = true;

                queue.offer(newNode);

            }
            if (!visited[temp.x + 1][temp.y] &&
                    matrix[temp.x + 1][temp.y] != 1 &&
                    matrix[temp.x + 1][temp.y] != 4 &&
                    matrix[temp.x + 1][temp.y] != 5) {
                newNode = new Node(temp.x + 1, temp.y);
                newNode.dir = temp;
                visited[temp.x][temp.y + 1] = true;

                queue.offer(newNode);

            }
        }
        while (temp.dir != null) {
            System.out.println(temp.x + " " + temp.y);
            temp = temp.dir;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Color color = switch (matrix[i][j]) {
                    case 1 -> Color.black;
                    case -1 -> Color.yellow;
                    default -> Color.white;
                };
                g.setColor(color);
                g.fillRect(j*25+100, i*25+100, 25, 25);
//                g.drawImage(image,j * tileSize + 100, i * tileSize + 100, null);
            }
        }

        g.setColor(Color.BLUE);
        g.fillRect(player.y * tileSize + 100, player.x * tileSize + 100, tileSize, tileSize);

        if (gameOver) return;
        moveGhost();
        newStack.pop();
        Node node = newStack.peek();
        g.setColor(Color.white);
        g.fillRect(wolf.y*25+100, wolf.x*25+100, 25, 25);
//        g.drawImage(floor,wolf.y * tileSize + 100, wolf.x * tileSize + 100, null);

        wolf.x = node.x;
        wolf.y = node.y;
        g.setColor(Color.red);
        g.fillRect(wolf.y*25+100, wolf.x*25+100, 25, 25);
//        g.drawImage(virus,wolf.y * tileSize + 100, wolf.x * tileSize + 100, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        switch (e.getKeyChar()) {
//            case 'a' : if (matrix[player.x][player.y-1]!=1) player.y-=1; break;
//            case 'd' : if (matrix[player.x][player.y+1]!=1) player.y+=1; break;
//            case 's' : if (matrix[player.x+1][player.y]!=1) player.x+=1; break;
//            case 'w' : if (matrix[player.x-1][player.y]!=1) player.x-=1; break;
//        }

//        moved = 1;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a' -> {
                if (matrix[player.x][player.y - 1] != 1) player.y -= 1;
            }
            case 'd' -> {
                if (matrix[player.x][player.y + 1] != 1) player.y += 1;
            }
            case 's' -> {
                if (matrix[player.x + 1][player.y] != 1) player.x += 1;
            }
            case 'w' -> {
                if (matrix[player.x - 1][player.y] != 1) player.x -= 1;
            }
        }
        if (player.x == matrix.length-2&&player.y==matrix[0].length-2) gameOver= true;
        moved = 1;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) {
            timer.stop();

        }
        repaint();
    }
}
