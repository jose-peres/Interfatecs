import java.io.*;
import java.text.Normalizer;

public class palindromo {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;

    while ((line = in.readLine()) != null) {
      if (line.length() > 10000) {
        System.out.println("Input error");
        return;
      }
      line = line.replace(" ", "").replace("[^A-Za-z0-9]", "").toLowerCase();

      String normalized = Normalizer.normalize(line, Normalizer.Form.NFD);
      String withoutAccents = normalized.replaceAll("[^\\p{ASCII}]", "").toLowerCase();
      String alphanumericOnly = withoutAccents.replaceAll("^[^a-z0-9]+", "");
      alphanumericOnly = alphanumericOnly.replaceAll("[^a-z0-9]+$", "");

      boolean isPalindrome = true;
      int left = 0;
      int right = alphanumericOnly.length() - 1;
      while (left < right) {
        if (alphanumericOnly.charAt(left) != alphanumericOnly.charAt(right)) {
          isPalindrome = false;
          break;
        }
        left++;
        right--;
      }

      if (isPalindrome) {
        System.out.println("Parabens, voce encontrou o Palindromo Perdido!");
      } else {
        System.out.println("A busca continua, o Palindromo Perdido ainda nao foi encontrado.");
      }
    }
  }
}