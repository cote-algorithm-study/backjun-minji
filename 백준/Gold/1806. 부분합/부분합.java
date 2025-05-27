
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //누적합
            int[] prefixSum = new int[N + 1];
            prefixSum[0] = 0;
            for (int i = 1; i <= N; i++) {
                prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
            }

            //구간별 합 구하기
            int start = 0;
            int end = 0;
            int result = Integer.MAX_VALUE;
            while (end <= N) {
                int sum = prefixSum[end] - prefixSum[start];
                if (sum >= S) {
                    result = Math.min(result, end - start);
                    start++;
                } else {
                    end++;
                }

            }
            System.out.println(result == Integer.MAX_VALUE ? 0 : result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
