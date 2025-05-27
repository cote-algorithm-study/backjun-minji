
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, C;
    static int[] houses;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            houses = new int[N];
            for (int i = 0; i < N; i++) {
                houses[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(houses);
            int left = 1;
            int right = houses[N - 1] - houses[0];
            int result = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (canInstall(mid)) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean canInstall(int distance) {
        int count = 1;
        int last = houses[0];
        for (int i = 1; i < N; i++) {
            if (houses[i] - last >= distance) {
                count++;
                last = houses[i];
            }
        }
        return count >= C;
    }

}
