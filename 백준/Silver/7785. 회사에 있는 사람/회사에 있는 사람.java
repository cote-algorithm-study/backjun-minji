import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Set<String> staffSet = new HashSet<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String log = st.nextToken();

                if (log.equals("enter")) {
                    staffSet.add(name);
                } else {
                    staffSet.remove(name);
                }
            }

            List<String> staffList = new ArrayList<>(staffSet);
            Collections.sort(staffList, Collections.reverseOrder());
            for (String staff : staffList) {
                System.out.println(staff);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
