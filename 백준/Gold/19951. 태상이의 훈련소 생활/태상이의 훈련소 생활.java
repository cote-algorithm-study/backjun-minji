
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] origin = new int[N];
            for (int i = 0; i < N; i++) {
                origin[i] = Integer.parseInt(st.nextToken());
            }

            int[] diff = new int[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int k = Integer.parseInt(st.nextToken());

                diff[a] += k;
                diff[b + 1] -= k; //b+1부터는 차이를 멈춤
            }

            // diff의 누적합 더하기
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += diff[i];
                origin[i] += sum;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int s : origin) {
                stringBuilder.append(s).append(" ");
            }

            System.out.println(stringBuilder);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
