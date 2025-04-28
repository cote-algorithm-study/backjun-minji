
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
                int H = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());
                int N = Integer.parseInt(st.nextToken());

                int floor = (N % H == 0) ? H : N % H;
                int room = (N % H == 0) ? N / H : N / H + 1;

                String answer = String.format("%d%02d", floor, room);
                System.out.println(answer);
            }

        }
    }

}
