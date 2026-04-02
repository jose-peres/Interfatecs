import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class silas {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int p = Integer.valueOf(in.readLine());
    String[] parts = in.readLine().split(" ");
    int x = Integer.valueOf(parts[0]);
    int y = Integer.valueOf(parts[1]);

    if (p < 1 || p > 10000) {
      System.out.println("Input error (p): " + p);
      return;
    }

    if (x < 1 || x > 80) {
      System.out.println("Input error (x): " + x);
      return;
    }

    if (y < 1 || y > 80) {
      System.out.println("Input error (y): " + y);
      return;
    }

    char[][] map = new char[x][y];
    Point start = new Point(0, 0, 0);

    for (int i = 0; i < x; i++) {
      parts = in.readLine().split(" ");
      if (parts.length != y) {
        System.out.println("Input error line parts length not equal to y" + parts.length + ": " + parts);
        return;
      }
      for (int j = 0; j < y; j++) {
        String part = parts[j];
        if (part.equals("S")) {
          start = new Point(i, j, 0);
          map[i][j] = '.';
        } else if (part.equals(".")) {
          map[i][j] = '.';
        } else if (part.equals("#")) {
          map[i][j] = '#';
        } else if (part.equals("K")) {
          map[i][j] = 'K';
        } else {
          int monsterPower = Integer.parseInt(part);
          if (monsterPower <= p) {
            map[i][j] = '.';
          } else {
            map[i][j] = '#';
          }
        }
      }
    }

    int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    Queue<Point> queue = new LinkedList<>();
    queue.add(start);
    boolean[][] visited = new boolean[x][y];
    visited[start.x][start.y] = true;

    while (!queue.isEmpty()) {
      Point cell = queue.poll();
      if (map[cell.x][cell.y] == 'K') {
        System.out.println(cell.dist);
        return;
      }
      for (int i = 0; i < 4; i++) {
        int newX = cell.x + dir[i][0];
        int newY = cell.y + dir[i][1];
        if (newX >= 0 && newY >= 0 && newX < x && newY < y && !visited[newX][newY] && map[newX][newY] != '#') {
          queue.add(new Point(newX, newY, cell.dist + 1));
          visited[newX][newY] = true;
        }
      }
    }

    System.out.println('N');
  }

  private static class Point {
    int x, y, dist;

    public Point(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }
  }
}
