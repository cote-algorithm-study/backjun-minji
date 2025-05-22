import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] trees;
    static int N;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            trees = new int[N];
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(trees);

            int left = 0;
            int right = trees[N - 1];
            int result = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                long sum = getSum(mid);
                if (sum >= M) {
                    result = mid;
                    left = mid + 1;  // 더 높은 높이로도 시도
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long getSum(int height) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > height) {
                sum += trees[i] - height;
            }
        }
        return sum;
    }

}
