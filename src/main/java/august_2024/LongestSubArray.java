package august_2024;

import java.util.ArrayList;
import java.util.List;

public class LongestSubArray {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 3, 3, 1, 2, 1, 2};
        int[] arr = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        int target = 1;

        int[] result = longestSubArray(arr, target);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int[] longestSubArray(int[] arr, int target) {
        if (arr.length == 0) {
            return new int[] {-1, -1};
        }
        int left = 0;
        int right = 0;
        int longest = Integer.MIN_VALUE;
        int sum = 0;
        List<Integer> indexes = new ArrayList<>();
        while (right < arr.length) {
            sum += arr[right];
            while (left < right && sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                if (indexes.isEmpty()) {
                    indexes.add(left);
                    indexes.add(right);
                    longest = Math.max(longest, right - left);
                } else {
                    if (right - left > longest) {
                        longest = right - left;
                        indexes.set(0, left);
                        indexes.set(1, right);
                    }
                }
            }
            right++;
        }
        if (longest == Integer.MIN_VALUE) {
            return new int[] {-1, -1};
        }
        return new int[] {indexes.get(0), indexes.get(1)};
    }


}
