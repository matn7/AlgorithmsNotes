package october_2023;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarraySum {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 3, 3, 1, 2, 1, 2};
        int[] arr = {0, 0, 0, 1, 0, 0, 0, 0, 0};
        int target = 10;

        longestSubarraySum(arr, target);
    }

    // O(n) time | O(1) space
    public static int[] longestSubarraySum(int[] arr, int target) {
        //           l
        // [1, 2, 3, 4, 3, 3, 1, 2, 1, 2]
        //                 r
        //  *
        List<Integer> indicies = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sum = 0; // 7
        int[] res = {0, 0};
        while (right < arr.length) {
            sum += arr[right];
            while (left < right && sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                if (indicies.size() == 0) {
                    indicies.add(left);
                    indicies.add(right);
                } else if (right - left > indicies.get(1) - indicies.get(0)) {
                    indicies.set(0, left);
                    indicies.set(1, right);
                }
            }
            right++;
        }
        if (indicies.size() == 0) {
            return new int[] {};
        }

        return new int[] {indicies.get(0), indicies.get(1)};
    }

}
