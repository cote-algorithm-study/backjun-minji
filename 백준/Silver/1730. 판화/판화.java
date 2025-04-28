
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] dx = {-1, 1, 0, 0}; //U, D, L, R
    static int[] dy = {0, 0, -1, 1};
    static char[] dir = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            char[] move = br.readLine().toCharArray();
            char[][] grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(grid[i], '.');
            }
            solution(move, grid);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution(char[] move, char[][] grid) {
        int x = 0;
        int y = 0;
        for (char c : move) {
            int d = getDirection(c);
            if (d == -1)
                continue;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (c == 'U' || c == 'D') { //세로 이동
                grid[x][y] = (grid[x][y] == '-') ? '+' : (grid[x][y] == '+' ? '+' : '|');
                grid[nx][ny] = (grid[nx][ny] == '-') ? '+' : (grid[nx][ny] == '+' ? '+' : '|');
            } else {
                grid[x][y] = (grid[x][y] == '|') ? '+' : (grid[x][y] == '+' ? '+' : '-');
                grid[nx][ny] = (grid[nx][ny] == '|') ? '+' : (grid[nx][ny] == '+' ? '+' : '-');
            }
            x = nx;
            y = ny;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(new String(grid[i]));
        }
    }

    private static int getDirection(char c) {
        for (int i = 0; i < 4; i++) {
            if (dir[i] == c)
                return i;
        }
        return -1;
    }

}
