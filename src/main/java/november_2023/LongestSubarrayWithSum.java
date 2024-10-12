package november_2023;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayWithSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 3, 1, 2, 1, 2};
        int target = 10;

        int[] res = longestSubarray(arr, target);
        System.out.println();
    }

    // O(n) time | O(1) space
    public static int[] longestSubarray(int[] arr, int target) {
        List<Integer> indicies = new ArrayList<>();
        int startIdx = 0;
        int endIdx = 0;

        int sum = 0;

        while (endIdx < arr.length) {
            sum += arr[endIdx];
            while (startIdx < endIdx && sum > target) {
                sum -= arr[startIdx];
                startIdx++;
            }
            if (sum == target) {
                if (indicies.isEmpty()) {
                    indicies.add(0, startIdx);
                    indicies.add(1, endIdx);
                } else if (endIdx - startIdx > indicies.get(1) - indicies.get(0)) {
                    indicies.set(0, startIdx);
                    indicies.set(1, endIdx);
                }
            }
            endIdx++;
        }

        if (indicies.isEmpty()) {
            return new int[] {-1, -1};
        }

        return new int[] {indicies.get(0), indicies.get(1)};
    }

}
