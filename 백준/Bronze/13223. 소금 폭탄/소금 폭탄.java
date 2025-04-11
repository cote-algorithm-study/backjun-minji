import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] now = sc.nextLine().split(":");
        String[] after = sc.nextLine().split(":");
        System.out.println(solution(now, after));
    }

    private static String solution(String[] now, String[] after) {
        int nowSec = toSecond(now);
        int afterSec = toSecond(after);
        int dif = afterSec - nowSec;

        if (dif <= 0)
            dif += 24 * 60 * 60;

        int h = dif / 3600;
        int m = (dif % 3600) / 60;
        int s = dif % 60;

        return String.format("%02d:%02d:%02d", h, m, s);
    }

    private static int toSecond(String[] time) {
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        int s = Integer.parseInt(time[2]);
        return h * 3600 + m * 60 + s;
    }

}
