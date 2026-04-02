import java.io.*;
import java.util.Arrays;

public class blaittland {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());

    String bookOrder = reader.readLine();

    char[] characters = bookOrder.toCharArray();
    Arrays.sort(characters);
    String bookSteps = new String(characters);

    int numReads = 0;
    for (int i = 0; i < N; i++) {
      char book = bookOrder.charAt(i);
      int whereBookIsInCorrect = bookSteps.indexOf(book);
      if (book != bookSteps.charAt(i)) {
        int distance = whereBookIsInCorrect - i;
        if (distance > 5) {
          System.out.println("A Database Systems student read a book.");
          return;
        }
        numReads += distance;
        bookSteps = bookSteps.substring(0, i) + book + bookSteps.substring(i, whereBookIsInCorrect)
            + bookSteps.substring(whereBookIsInCorrect + 1);
      }

    }
    System.out.println(numReads);
  }
}
