import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class foraminis {

  private static double[] h = { 1 / Math.sqrt(2), 1 / Math.sqrt(2) };
  private static double[] g = { 1 / Math.sqrt(2), -1 / Math.sqrt(2) };

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(in.readLine());
    if (n > 500) {
      System.out.println("Input error");
      return;
    }

    for (int i = 0; i < n; i++) {
      double[] s = new double[8];
      String[] parts = in.readLine().split(" ");
      for (int j = 0; j < 8; j++) {
        s[j] = Double.parseDouble(parts[j]);
      }

      double[] r = new double[8];

      // Haar filter
      for (int j = 0; j < 8; j += 2) {
        r[j] = h[0] * s[j] + h[1] * s[j + 1];
        r[j + 1] = g[0] * s[j] + g[1] * s[j + 1];
      }

      double energyLF = 0;
      double energyS = 0;
      for (int j = 0; j < 8; j++) {
        if (j % 2 == 0) {
          energyLF += Math.pow(r[j], 2);
        }
        energyS += Math.pow(s[j], 2);
      }

      // Print result
      if (energyLF / energyS > 0.5) {
        System.out.println("INIMIGO");
      } else {
        System.out.println("-");
      }
    }
  }
}
