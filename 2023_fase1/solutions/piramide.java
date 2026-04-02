import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class piramide {

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line = in.readLine();
    String[] parts = line.split(" ");
    int N = Integer.parseInt(parts[0]);
    if (N < 1 || N > 26) {
      System.out.println("Invalid input");
    }
    String P = parts[1];
    if (!P.equals("maiusculas") && !P.equals("minusculas")) {
      System.out.println("Invalid input");
    }

    char firstChar = P.equals("maiusculas") ? 'A' : 'a';
    StringBuilder out = new StringBuilder();
    StringBuilder chars = new StringBuilder();
    String pre = ".".repeat(25);
    for (int i = 0; i < N; i++) {
      out.append(pre.substring(i));
      chars.append((char) (firstChar + i));
      out.append(chars);
      out.append("\n");
    }
    System.out.print(out);
  }

}
