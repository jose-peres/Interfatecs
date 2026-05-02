import java.io.*;

public class crausio {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] parts = br.readLine().split(" ");
    int L = Integer.parseInt(parts[0]);
    int C = Integer.parseInt(parts[1]);
    int B = Integer.parseInt(parts[2]);

    parts = br.readLine().split(" ");
    int X = Integer.parseInt(parts[0]) - 1;
    int Y = Integer.parseInt(parts[1]) - 1;

    char[] commands = br.readLine().toCharArray();

    int collisionCount = 0;
    for (int i = 0; i < B && i < commands.length; i++) {
      char command = commands[i];

      switch (command) {
        case 'C':
          if (X == 0)
            collisionCount++;
          else
            X--;
          break;
        case 'B':
          if (X == L - 1)
            collisionCount++;
          else
            X++;
          break;
        case 'E':
          if (Y == 0)
            collisionCount++;
          else
            Y--;
          break;
        case 'D':
          if (Y == C - 1)
            collisionCount++;
          else
            Y++;
          break;
      }
    }

    System.out.println((X + 1) + " " + (Y + 1) + " " + collisionCount);
  }
}
