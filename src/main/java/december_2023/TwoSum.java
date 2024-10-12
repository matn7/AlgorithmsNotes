package december_2023;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;

        int[] result = twoSum(nums, target);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        // [2, 7, 11, 15]
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int key = target - num; // 18 - 11 = 7
            if (numsMap.containsKey(key)) {
                result[0] = numsMap.get(key); // 7
                result[1] = i; // 11
                return result;
            }
            numsMap.put(num, i); // {2, 7}
        }

        return result;
    }

}
