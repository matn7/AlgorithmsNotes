package november_2023;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int target = 10;

        int[] result = twoNumberSum(array, target);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int[] twoNumberSum(int[] arr, int target) {

        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int key = target - num;
            if (seen.containsKey(key)) {
                return new int[] {num, key};
            } else {
                seen.put(num, i);
            }
        }

        return new int[] {-1, -1};
    }

}
