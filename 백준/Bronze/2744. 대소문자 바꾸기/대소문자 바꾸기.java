import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solution(s);
    }

    private static void solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(Character.isUpperCase(c)) {
                answer.append(Character.toLowerCase(c));
            }else{
                answer.append(Character.toUpperCase(c));
            }
        }
        System.out.println(answer);
    }
}
