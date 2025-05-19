import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;

public class Main {

       public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Set<String> origin = new HashSet<>();
            for (int i = 0; i < N; i++) {
                origin.add(br.readLine());
            }

            int count = 0;
            for (int i = 0; i < M; i++) {
                String s = br.readLine();
                if(origin.contains(s)){
                    count++;
                }
            }

            System.out.println(count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
