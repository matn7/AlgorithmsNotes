package problems.other;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;

        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(nums, target);
        System.out.println();
    }

    // O(n^2) time | O(1) space
    public int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    // O(n) time | O(n) space
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (values.containsKey(diff)) {
                return new int[] {values.get(diff), i};
            }
            values.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

}
