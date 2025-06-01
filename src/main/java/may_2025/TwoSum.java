package may_2025;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // O(n) time | O(n) space
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; // 7
            int diff = target - num; // 9 - 7 = 2
            if (seen.containsKey(diff)) {
                return new int[] {seen.get(diff), i};
            }
            seen.put(num, i); // { [2, 0] }
        }
        return new int[] {};
    }

}
