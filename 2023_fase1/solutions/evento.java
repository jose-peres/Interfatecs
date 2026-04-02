import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class evento {

  static int[][] points;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;

    while (!(line = in.readLine()).equals("0 0")) {
      String[] parts = line.split(" ");
      int n = Integer.parseInt(parts[0]);
      int m = Integer.parseInt(parts[1]);

      if (n < 2 || n > 2000 || m < 2 || m > (n * (n - 1)) / 2) {
        System.out.println("Input error");
        return;
      }

      points = new int[n + 1][n + 1];
      visited = new boolean[n + 1];

      for (int i = 0; i < m; i++) {
        parts = in.readLine().split(" ");
        int v = Integer.parseInt(parts[0]);
        int w = Integer.parseInt(parts[1]);
        int d = Integer.parseInt(parts[2]);

        points[v][w] = 1;
        if (d == 2) {
          points[w][v] = 1;
        }
      }

      boolean isConnected = true;
      for (int i = 1; i <= n; i++) {
        visited = new boolean[n + 1];
        depthFirstSearch(i, n);
        for (int j = 1; j <= n; j++) {
          if (!visited[j]) {
            isConnected = false;
            break;
          }
        }
        if (!isConnected) {
          break;
        }
      }

      if (isConnected) {
        System.out.println("S");
      } else {
        System.out.println("N");
      }
    }
  }

  static void depthFirstSearch(int node, int n) {
    visited[node] = true;
    for (int next = 1; next <= n; next++) {
      if (points[node][next] == 1 && !visited[next]) {
        depthFirstSearch(next, n);
      }
    }
  }
}
