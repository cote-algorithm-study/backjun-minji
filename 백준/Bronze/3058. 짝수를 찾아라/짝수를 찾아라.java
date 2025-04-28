import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int sum = 0;
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < 7; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp % 2 == 0) {
                        sum += temp;
                        min = Math.min(min, temp);
                    }
                }
                System.out.println(sum + " " + min);

            }
        }
    }

}
