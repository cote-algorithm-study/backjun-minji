import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] now = sc.nextLine().split(":");
        String[] after = sc.nextLine().split(":");

        System.out.println(solution(now, after));
    }

    private static String solution(String[] now, String[] after) {
        int next = 0;
        int[] result = new int[3];

        for (int i = 2; i > -1; i--) {
            int dif = Integer.parseInt(after[i]) - Integer.parseInt(now[i]) - next;
            next = 0;
            if (dif < 0) {
                if (i == 0)
                    dif += 24;
                else
                    dif += 60;
                next++;
            }
            result[i] = dif;
        }
        // 시, 분, 초가 모두 0이면 24:00:00으로 바꿔줌
        if (result[0] == 0 && result[1] == 0 && result[2] == 0) {
            result[0] = 24;
        }
        return String.format("%02d:%02d:%02d", result[0], result[1], result[2]);
    }
}