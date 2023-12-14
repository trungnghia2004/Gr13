import java.util.LinkedList;
import java.util.Queue;

public class Test2 {
    static class Node {
        int x, y;
        Node dir;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map = {
            {1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1}
    };
    Queue<Node> queue = new LinkedList<>();
    Node temp;
    void findPathUsingBFS(int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        queue.offer(new Node(sx, sy));
        visited[sx][sy] = true;
        Node newNode;
        while ((temp=queue.poll())!=null) {
            if (temp.x==ex&&temp.y==ey) {
                queue = new LinkedList<>();
                break;
            }
            if (!visited[temp.x][temp.y-1]&&
                    map[temp.x][temp.y-1]!=1&&
                    map[temp.x][temp.y-1]!=4&&
                    map[temp.x][temp.y-1]!=5) {
                newNode = new Node(temp.x, temp.y-1);
                newNode.dir = temp;
                visited[temp.x][temp.y-1] = true;
                queue.offer(newNode);

            }
            if (!visited[temp.x][temp.y+1]&&
                    map[temp.x][temp.y+1]!=1&&
                    map[temp.x][temp.y+1]!=4&&
                    map[temp.x][temp.y+1]!=5) {
                newNode = new Node(temp.x, temp.y+1);
                newNode.dir = temp;
                visited[temp.x][temp.y+1] = true;

                queue.offer(newNode);
            }
            if (!visited[temp.x-1][temp.y]&&
                    map[temp.x-1][temp.y]!=1&&
                    map[temp.x-1][temp.y]!=4&&
                    map[temp.x-1][temp.y]!=5) {
                newNode = new Node(temp.x-1, temp.y);
                newNode.dir = temp;
                visited[temp.x-1][temp.y] = true;

                queue.offer(newNode);

            }
            if (!visited[temp.x+1][temp.y]&&
                    map[temp.x+1][temp.y]!=1&&
                    map[temp.x+1][temp.y]!=4&&
                    map[temp.x+1][temp.y]!=5) {
                newNode = new Node(temp.x+1, temp.y);
                newNode.dir = temp;
                visited[temp.x][temp.y+1] = true;

                queue.offer(newNode);

            }
        }
        while (temp.dir!=null) {
            System.out.println(temp.x + " " + temp.y);
            temp = temp.dir;
        }
    }
}
