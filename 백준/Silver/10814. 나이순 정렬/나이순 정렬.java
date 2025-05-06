
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            List<Member> members = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int age = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                members.add(new Member(age, name, i));
            }

            members.sort((o1, o2) -> {
                if (o1.age == o2.age) {
                    return o1.idx - o2.idx;
                }
                return o1.age - o2.age;
            });

            StringBuilder sb = new StringBuilder();
            for (Member m : members) {
                sb.append(m.age).append(' ').append(m.name).append('\n');
            }
            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Member {

        int age;
        String name;
        int idx;

        public Member(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }

    }

}
