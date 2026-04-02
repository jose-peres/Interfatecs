import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class radar {

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int speedLimit = Integer.valueOf(in.readLine());

    if (speedLimit < 0 || speedLimit > 300) {
      System.out.println("Input error (speedLimit): " + speedLimit);
      return;
    }

    double maxSpeed;
    if (speedLimit <= 107) {
      maxSpeed = speedLimit + 7;
    } else {
      maxSpeed = speedLimit + 0.07 * speedLimit;
    }

    System.out.println(Math.round(maxSpeed));
  }
}
