package september_2025;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // O(n) time | O(n) space
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        Map<Integer, Integer> seenMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (seenMap.containsKey(diff)) {
                return new int[] {seenMap.get(diff), i};
            }
            seenMap.put(num, i);
        }
        return new int[] {-1, -1};
    }


}
