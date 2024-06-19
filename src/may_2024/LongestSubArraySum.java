package may_2024;

import java.util.ArrayList;
import java.util.List;

public class LongestSubArraySum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3, 3, 1, 2, 1, 2};
//        int[] nums = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        int target = 10;

        int[] result = longestSubArray2(nums, target);
        System.out.println(result);
    }

    public static int[] longestSubArray(int[] nums, int target) {
        int[] arr = {-1, -1};
        int start = 0;
        int end = 0;
        int currSum = 0;

        while (end < nums.length) {
            if (currSum < target) {
                currSum += nums[end];
                end++;
            } else if (currSum > target) {
                currSum -= nums[start];
                start++;
            } else {
                if (arr[1] - arr[0] <= end - 1 - start) {
                    arr[0] = start;
                    arr[1] = end - 1;
                }
                currSum -= nums[start];
                start++;
            }
        }
        return arr;
    }

    // O(n) time | O(1) space
    public static int[] longestSubArray2(int[] nums, int target) {
        List<Integer> indicies = new ArrayList<>();
        int start = 0;
        int end = 0;
        int currSum = 0;
        while (end < nums.length) {
            currSum += nums[end];
            while (start < end && currSum > target) {
                currSum -= nums[start];
                start++;
            }
            if (currSum == target) {
                if (indicies.isEmpty()) {
                    indicies.add(0, start);
                    indicies.add(1, end);
                } else if (end - start > indicies.get(1) - indicies.get(0)) {
                    indicies.set(0, start);
                    indicies.set(1, end);
                }
            }
            end++;
        }
        if (indicies.isEmpty()) {
            return new int[] {};
        }
        return new int[] {indicies.get(0), indicies.get(1)};
    }

}
