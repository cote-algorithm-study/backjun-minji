import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>(); //압축값 저장 map
            int[] arr = new int[N]; //기존 배열
            int[] sorted = new int[N]; //정렬한 배열

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(input[i]);
                arr[i] = num;
                sorted[i] = num;
            }

            Arrays.sort(sorted);

            int idx = 0;
            for (int x : sorted) {
                if (!map.containsKey(x)) {
                    map.put(x, idx++);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int num : arr) {
                stringBuilder.append(map.get(num)).append(" ");
            }

            System.out.println(stringBuilder);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
