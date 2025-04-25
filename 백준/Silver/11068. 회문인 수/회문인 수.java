
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                boolean answer = false;
                for (int j = 2; j <= 64; j++) {
                    if (isPalindrome(changeRadix(N, j))) {
                        answer = true;
                        break;
                    }
                }
                System.out.println(answer ? 1 : 0);
            }
        }
    }

    public static String changeRadix(int N, int K) {
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            if (N % K < 10) {
                sb.append(N % K);
            } else {
                sb.append((char)('A' + (N % K - 10)));
            }
            N = N / K;
        }
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
