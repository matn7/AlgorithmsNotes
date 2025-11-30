package november_2025;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK3 {

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumsMap = new HashMap<>();
        prefixSumsMap.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            if (prefixSumsMap.containsKey(prefixSum - k)) {
                count += prefixSumsMap.get(prefixSum - k);
            }
            prefixSumsMap.put(prefixSum, prefixSumsMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

}
