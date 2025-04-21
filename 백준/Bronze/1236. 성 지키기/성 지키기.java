import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            int emptyRow = 0;
            for (int i = 0; i < N; i++) {
                boolean hasGuard = false;
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'X') {
                        hasGuard = true;
                        break;
                    }
                }
                if (!hasGuard)
                    emptyRow++;
            }

            int emptyCol = 0;
            for (int i = 0; i < M; i++) {
                boolean hasGuard = false;
                for (int j = 0; j < N; j++) {
                    if (map[j][i] == 'X') {
                        hasGuard = true;
                        break;
                    }
                }
                if (!hasGuard)
                    emptyCol++;
            }

            System.out.println(Math.max(emptyRow, emptyCol));

        }

    }

}
