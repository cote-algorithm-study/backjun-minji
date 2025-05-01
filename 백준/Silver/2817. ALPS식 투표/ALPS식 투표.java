import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int X = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            List<Staff> staffList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int voteCount = Integer.parseInt(st.nextToken());

                if (X * 0.05 > voteCount) {
                    continue;
                }
                staffList.add(new Staff(voteCount, name));
            }

            List<Score> scoreList = new ArrayList<>();

            //득표수를 1~14로 나눈 값 추가
            for (int i = 1; i <= 14; i++) {
                for (Staff staff : staffList) {
                    scoreList.add(new Score((float)staff.vote / i, staff.name));
                }
            }

            scoreList.sort((o1, o2) -> Float.compare(o2.votes, o1.votes));

            for (int i = 0; i < 14; i++) {
                for (Staff staff : staffList) {
                    if (scoreList.get(i).name.equals(staff.name)) {
                        staff.chip++;
                    }
                }
            }

            staffList.sort(Comparator.comparing(o -> o.name));

            for (Staff staff : staffList) {
                System.out.println(staff.name + " " + staff.chip);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static class Staff {

        int vote;
        int chip = 0;
        String name;

        public Staff(int vote, String name) {
            this.vote = vote;
            this.name = name;
        }

    }

    static class Score {

        float votes;
        String name;

        public Score(float votes, String name) {
            this.votes = votes;
            this.name = name;
        }

    }

}
