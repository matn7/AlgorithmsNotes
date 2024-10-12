package september_2024;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 3};
        int target = 4;

        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {};
        }
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int key = target - num;
            if (seen.containsKey(key)) {
                return new int[] {seen.get(key), i};
            }
            seen.put(num, i);
        }
        return new int[] {};
    }

}
