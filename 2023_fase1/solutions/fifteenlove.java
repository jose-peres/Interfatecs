import java.io.*;

public class fifteenlove {
  static int p1p = 0, p2p = 0; // points
  static int p1g = 0, p2g = 0; // games
  static int p1s = 0, p2s = 0; // sets
  static boolean tie = false;

  static void resetPoints() { p1p = p2p = 0; }
  static void resetGames() { p1g = p2g = 0; }

  static boolean winGame() {
    if (!tie && (p1p >= 4 || p2p >= 4) && Math.abs(p1p - p2p) >= 2) {
      if (p1p > p2p) p1g++; else p2g++;
      resetPoints();
      return true;
    }
    if (tie && (p1p >= 7 || p2p >= 7) && Math.abs(p1p - p2p) >= 2) {
      if (p1p > p2p) p1g++; else p2g++;
      resetPoints();
      return true;
    }
    return false;
  }

  static boolean winSet() {
    if (p1g == 6 && p2g == 6) tie = true;

    if (p1g == 7 || p2g == 7 || (Math.max(p1g, p2g) >= 6 && Math.abs(p1g - p2g) >= 2)) {
      if (p1g > p2g) p1s++; else p2s++;
      resetGames();
      tie = false;
      return true;
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();

    boolean serve = true;

    for (int i = 0; i < n; i++) {
      if (p1s == 3 || p2s == 3) break;

      char c = s.charAt(i);

      if (c == 'W') {
        if (serve) p1p++; else p2p++;
      } else {
        if (serve) p2p++; else p1p++;
      }

      if (winGame()) {
        serve = !serve;
        winSet();
      }
    }

    String[] pts = {"0","15","30","40"};

    String sp1 = tie ? String.valueOf(p1p)
        : (p1p <= 3 ? pts[p1p]
        : (p1p > p2p ? (p1p - p2p >= 2 ? "GAME" : "ADV") : "40"));

    String sp2 = tie ? String.valueOf(p2p)
        : (p2p <= 3 ? pts[p2p]
        : (p2p > p1p ? (p2p - p1p >= 2 ? "GAME" : "ADV") : "40"));

    System.out.println(p1s + "(" + p1g + ")[" + sp1 + "]-" +
                       p2s + "(" + p2g + ")[" + sp2 + "]");
  }
}
