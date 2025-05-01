
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            List<String> words = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                if (words.contains(s)) {
                    continue;
                }
                words.add(s);
            }

            words.sort((o1, o2) -> {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            });

            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word).append("\n");
            }
            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
