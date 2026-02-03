package january_2026;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // O(n) time | O(n) space
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int key = target - num;
            if (indexMap.containsKey(key)) {
                return new int[] {indexMap.get(key), i};
            }

            indexMap.put(num, i);
        }
        return new int[] {};
    }


}
