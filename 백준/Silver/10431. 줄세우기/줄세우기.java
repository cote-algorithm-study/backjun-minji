import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int P = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int[] arr = new int[20];
                int num = Integer.parseInt(st.nextToken());
                int cnt = 0;

                for (int j = 0; j < 20; j++) {
                    int current = Integer.parseInt(st.nextToken());

                    int k = j - 1;
                    while (k >= 0 && arr[k] > current) {
                        arr[k + 1] = arr[k];
                        cnt++;
                        k--;
                    }
                    arr[k + 1] = current;
                }
                System.out.println(num + " " + cnt);
            }

        }

    }

}
