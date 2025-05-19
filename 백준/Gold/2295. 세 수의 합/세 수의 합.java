
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(br.readLine());
            }
            // a+b+c = k -> a+b = k-c
            List<Integer> sumNums = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sumNums.add(nums[i] + nums[j]);
                }
            }
            Collections.sort(sumNums);

            int max = 0;
            Arrays.sort(nums);
            for (int i = N - 1; i >= 0; i--) {
                int k = nums[i];
                for (int j = 0; j < N; j++) {
                    int c = nums[j];
                    // k-c 가 sumNums에 있는지 확인
                    int target = k - c;
                    if (binarySearch(sumNums, target)) {
                        max = Math.max(max, k);
                    }
                }
            }
            System.out.println(max);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean binarySearch(List<Integer> sumNums, int target) {
        int start = 0;
        int end = sumNums.size() - 1;
        while (start <= end) {
            int midIdx = (start + end) / 2;
            int midVal = sumNums.get(midIdx);

            if (midVal < target) {
                start = midIdx + 1;
            } else if (midVal > target) {
                end = midIdx - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
