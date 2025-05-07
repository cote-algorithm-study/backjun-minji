import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>(); //압축값 저장 map
            int[] arr = new int[N]; //기존 배열
            Set<Integer> set = new TreeSet<>(); //중복제거할 set - 오름차순 정렬

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
                arr[i] = num;
            }

            int idx = 0;
            for (int num : set) {
                map.put(num, idx++);
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
