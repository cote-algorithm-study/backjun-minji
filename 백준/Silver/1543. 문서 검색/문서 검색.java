import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String s1 = br.readLine();
            String s2 = br.readLine();
            System.out.println(solution(s1,s2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int solution(String s1, String s2) {
        int cnt = 0;

        while(s1.length() >= s2.length()) {
            if(s1.contains(s2)) {
                s1 = s1.substring(s1.indexOf(s2)+s2.length());
                cnt++;
            }else{
                break;
            }
        }

        return cnt;
    }
}