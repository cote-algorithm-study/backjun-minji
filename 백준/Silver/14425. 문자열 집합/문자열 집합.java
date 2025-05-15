
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

            String[] origin = new String[N];
            for (int i = 0; i < N; i++) {
                origin[i] = br.readLine();
            }

            int count = 0;
            for (int i = 0; i < M; i++) {
                String s = br.readLine();
                for (String ori : origin) {
                    if (ori.equals(s))
                        count++;
                }
            }

            System.out.println(count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
