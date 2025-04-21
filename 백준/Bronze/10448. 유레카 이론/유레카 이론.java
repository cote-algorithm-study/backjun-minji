import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> triangles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            for (int n = 1; ; n++) {
                int t = n * (n + 1) / 2;
                if (t > 1000)
                    break;
                triangles.add(t);
            }

            for (int i = 0; i < N; i++) {
                int K = Integer.parseInt(br.readLine());
                System.out.println(IsTriangle(K));
            }
        }
    }

    private static int IsTriangle(int num) {
        for (int i = 0; i < triangles.size(); i++) {
            for (int j = 0; j < triangles.size(); j++) {
                for (int k = 0; k < triangles.size(); k++) {
                    if (triangles.get(i) + triangles.get(j) + triangles.get(k) == num) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

}