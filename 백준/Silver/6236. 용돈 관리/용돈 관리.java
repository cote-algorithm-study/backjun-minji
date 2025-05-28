
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] spend;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int maxSpend = 0;
            int totalSpend = 0;

            spend = new int[N];
            for (int i = 0; i < N; i++) {
                spend[i] = Integer.parseInt(br.readLine());
                maxSpend = Math.max(maxSpend, spend[i]);
                totalSpend += spend[i];
            }

            int left = maxSpend;
            int right = totalSpend;
            int result = totalSpend;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (canWithdraw(mid)) {
                    result = mid;
                    right = mid - 1;  // 더 작은 K가 있을 수 있으니 왼쪽 탐색
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean canWithdraw(int K) {
        int count = 1;
        int current = K;
        for (int i = 0; i < N; i++) {
            if (spend[i] > K) //하루동안 써야하는 돈보다 인출금액이 적으면 false
                return false;
            if (current < spend[i]) { //현재 가진 돈이 쓸 돈보다 적으면 인출
                count++;
                current = K;
            }
            current -= spend[i];
        }
        return count <= M;
    }

}
