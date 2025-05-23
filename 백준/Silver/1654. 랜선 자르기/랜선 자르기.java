
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int K;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);
            long left = 1;
            long right = arr[K - 1];
            long result = 0;

            while (left <= right) {
                long mid = (left + right) / 2;
                int count = getLineCount(mid);
                if (count >= N) {
                    result = mid;
                    left = mid + 1; // 조건 만족, 길이 늘려보기
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getLineCount(long length) {
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += (int)(arr[i] / length);
        }
        return sum;
    }

}
