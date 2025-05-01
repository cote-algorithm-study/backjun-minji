
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            char[] wheel = new char[N];
            Arrays.fill(wheel, '?');
            int position = 0;
            Set<Character> used = new HashSet<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                position = (position + Integer.parseInt(st.nextToken())) % N;
                char letter = st.nextToken().charAt(0);
                if (wheel[position] == '?') {
                    if (used.contains(letter)) {
                        System.out.println("!");
                        return;
                    }
                    wheel[position] = letter;
                    used.add(letter);
                } else {
                    if (wheel[position] != letter) {
                        System.out.println("!");
                        return;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                int idx = (position - i + N) % N;
                System.out.print(wheel[idx]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
