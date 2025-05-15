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
            int T = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N + 1][M + 1];

            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                String s = br.readLine();
                for (int j = 1; j <= M; j++) {
                    char temp = s.charAt(j - 1);
                    if (temp == '*') {
                        arr[i][j] = 1;
                    }
                }
            }

            while (T-- > 0) {
                int[][] next = new int[N + 1][M + 1];

                //누적합 배열 계산
                int[][] prefix = new int[N + 1][M + 1];
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + arr[i][j];
                    }
                }

                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        int x1 = Math.max(1, i - K);
                        int y1 = Math.max(1, j - K);
                        int x2 = Math.min(N, i + K);
                        int y2 = Math.min(M, j + K);

                        //주위: (x1, y1) 부터 (x2, y2) 까지 영역의 합 - 자기자신
                        int surround = prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1] - arr[i][j];

                        //생존규칙 적용
                        if (arr[i][j] == 1) {
                            next[i][j] = (surround >= a && surround <= b) ? 1 : 0;
                        } else if (arr[i][j] == 0) {
                            next[i][j] = (surround > a && surround <= b) ? 1 : 0;
                        }
                    }
                }
                //next 배열 -> 기존 배열 복사
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        arr[i][j] = next[i][j];
                    }
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int temp = arr[i][j];
                    if (temp == 0) {
                        stringBuilder.append('.');
                    } else {
                        stringBuilder.append('*');
                    }
                }
                stringBuilder.append('\n');
            }
            System.out.println(stringBuilder);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
