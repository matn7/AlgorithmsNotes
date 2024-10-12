package september_2023;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;

        twoNumberSum(array, targetSum);
    }

    // O(n) time | O(n) space
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        // [3, 5, -4, 8, 11, 1, -1, 6]
        // seen = {3, 5, -4, 8, 11, 1}
        Map<Integer, Boolean> seen = new HashMap<>();
        for (int num : array) {
            int sum = targetSum - num; // 10 - (-1) = 11
            if (seen.containsKey(sum)) {
                return new int[] {num, sum};
            } else {
                seen.put(num, Boolean.TRUE);
            }
        }
        return new int[0];
    }

}
