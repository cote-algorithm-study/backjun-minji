import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] count = new int[10001];

            for (int i = 0; i < N; i++) {
                count[Integer.parseInt(br.readLine())]++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 10000; i++) {
                while (count[i]-- > 0) {
                    sb.append(i).append('\n');
                }
            }
            System.out.println(sb);
        }

    }

}
