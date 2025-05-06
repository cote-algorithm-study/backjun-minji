
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> bookMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String book = br.readLine();
                bookMap.put(book, bookMap.getOrDefault(book, 0) + 1);
            }

            String result = "";
            int max = 0;
            for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    result = entry.getKey();
                } else if (max == entry.getValue()) {
                    if (entry.getKey().compareTo(result) < 0) {
                        result = entry.getKey();
                    }
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
