package july_2025;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        TwoSum2 twoSum2 = new TwoSum2();
        int[] result = twoSum2.twoSum(nums, target);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (cache.containsKey(diff)) {
                return new int[] {cache.get(diff), i};
            }
            cache.put(num, i);
        }
        return new int[] {};
    }

}
