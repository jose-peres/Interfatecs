import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class spins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) break;

            StringBuilder sb = new StringBuilder();
            
            int i = 1;
            while (i * i <= x) {
                if (i > 1) sb.append(" ");
                sb.append(i * i);
                i++;
            }

            System.out.println(sb);
        }
    }
}
