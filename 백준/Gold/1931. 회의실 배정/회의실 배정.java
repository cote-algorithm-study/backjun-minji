
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Meeting> meetings = new ArrayList<>();
    static List<Integer> counts = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                meetings.add(new Meeting(start, end));
            }

            Collections.sort(meetings);

            int count = 0;
            int lastEndTime = 0; //종료시간 초기화
            for (Meeting meeting : meetings) {
                if (meeting.start >= lastEndTime) {
                    count++;
                    lastEndTime = meeting.end;
                }
            }
            System.out.println(count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Meeting implements Comparable<Meeting> {

        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }

    }

}
