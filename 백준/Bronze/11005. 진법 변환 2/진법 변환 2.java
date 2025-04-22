
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            while (N > 0) {
                int r = N % B;

                if (r < 10) {
                    sb.append((char)('0' + r)); // 0~9 → '0' ~ '9'
                } else {
                    sb.append((char)('A' + (r - 10))); // 10~35 → 'A' ~ 'Z'
                }
                N = N / B;
            }
            System.out.println(sb.reverse());
        }
    }

}