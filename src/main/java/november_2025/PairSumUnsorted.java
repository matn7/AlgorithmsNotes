package november_2025;

import java.util.HashMap;
import java.util.Map;

public class PairSumUnsorted {

    // O(n) time | O(n) space
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int key = target - num; // 2
            if (idxMap.containsKey(key)) {
                return new int[] {idxMap.get(key), i};
            }
            idxMap.put(num, i); // {2: 0, }
        }
        return new int[] {-1, -1};
    }



}
