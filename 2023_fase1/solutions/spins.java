import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class spins {

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    List<Integer> numSpins = new ArrayList<>();
    while (!(line = in.readLine()).equals("0")) {
      numSpins.add(Integer.valueOf(line));
    }
    Collections.sort(numSpins);
    int maxSpins = numSpins.get(numSpins.size() - 1);
    Boolean[] quantumGates = new Boolean[maxSpins];
    Arrays.fill(quantumGates, true);
    StringBuilder out = new StringBuilder();
    int lastSpin = 1;
    String lastResult = "1\n";
    for (int i = 0; i < numSpins.size(); i++) {
      int spins = numSpins.get(i);
      if (spins == lastSpin) {
        out.append(lastResult);
        continue;
      }
      for (int j = lastSpin + 1; j <= spins; j++) {
        for (int k = j; k <= maxSpins; k += j) {
          quantumGates[k - 1] = !quantumGates[k - 1];
        }
      }

      StringBuilder partialResult = new StringBuilder("");
      for (int j = 0; j < spins; j++) {
        if (quantumGates[j]) {
          partialResult.append(j + 1);
          partialResult.append(" ");
        }
      }
      partialResult.setLength(partialResult.length() - 1);
      lastSpin = spins;
      lastResult = partialResult.toString() + "\n";
      out.append(lastResult);
    }

    System.out.print(out.toString());
  }

}
