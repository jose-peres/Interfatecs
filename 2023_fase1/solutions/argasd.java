import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class argasd {

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String[] parts = in.readLine().split(" ");
    int nEmpr = Integer.parseInt(parts[0]);
    int qPadrao = Integer.parseInt(parts[1]);
    if (nEmpr < 3 || nEmpr > 10 || qPadrao < 10) {
      System.out.println("Input error");
      return;
    }

    int qDias = Integer.parseInt(in.readLine());
    if (qDias <= 0) {
      System.out.println("Input error");
      return;
    }

    int nRegs = nEmpr * nEmpr - nEmpr;
    StringBuilder out = new StringBuilder();
    int[][] estoque = new int[nEmpr][nEmpr];
    for (int i = 0; i < qDias; i++) {
      in.readLine(); // header
      out.append("Final dia ");
      out.append((i + 1));
      out.append("\n");
      for (int j = 0; j < nRegs; j++) {
        parts = in.readLine().split(" ");
        int empr1 = Integer.parseInt(parts[0]);
        int empr2 = Integer.parseInt(parts[1]);
        if (empr1 < 1 || empr1 > nEmpr || empr2 < 1 || empr2 > nEmpr) {
          System.out.println("Input error");
          return;
        }
        int botijoes = Integer.parseInt(parts[2]);
        estoque[empr1 - 1][empr2 - 1] += botijoes;
      }

      // List<Troca> trocas = new ArrayList<>();
      boolean trocas = false;
      for (int j = 0; j < nEmpr; j++) {
        for (int k = j + 1; k < nEmpr; k++) {
          if (estoque[j][k] >= qPadrao && estoque[k][j] >= qPadrao) {
            int vJK = estoque[j][k] / qPadrao;
            int vKJ = estoque[k][j] / qPadrao;
            out.append("  Trocas entre ");
            out.append(j + 1);
            out.append("(");
            out.append(vJK);
            out.append("v) e ");
            out.append(k + 1);
            out.append("(");
            out.append(vKJ);
            out.append("v)");
            out.append("\n");
            estoque[j][k] -= vJK * qPadrao;
            estoque[k][j] -= vKJ * qPadrao;
            trocas = true;
          }
        }
      }
      if (!trocas) {
        out.append("  Sem Trocas");
        out.append("\n");
      }
    }

    System.out.print(out.toString());
  }

}
