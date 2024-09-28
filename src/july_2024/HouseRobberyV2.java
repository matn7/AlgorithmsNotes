package july_2024;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberyV2 {

    public static void main(String[] args) {
        int[] nums = {6, 5, 5, 9, 3};

        int result = houseRobberyV2(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int houseRobbery(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //        *
        // [6, 5, 5, 9, 3]
        int[] result = new int[nums.length];
        // [6, 6, 0, 0, 0]
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(result[i - 1], nums[i] + result[i - 2]);
        }
        return result[nums.length - 1];
    }

    // O(n) time | O(n) space
    public static int houseRobberyV2(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, nums[0]);
        memo.put(1, Math.max(nums[0], nums[1]));
        return robHelper(nums, nums.length - 1, memo);
    }

    private static int robHelper(int[] nums, int index, Map<Integer, Integer> memo) {
        if (index < 0) {
            return 0;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        memo.put(index, Math.max(nums[index] + robHelper(nums, index - 2, memo),
                robHelper(nums, index - 1, memo)));
        return memo.get(index);
    }

}






















