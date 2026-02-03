package january_2026;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK2 {

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFreq = new HashMap<>();
        prefixFreq.put(0, 1);
        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            prefix += num;
            int key = prefix - k;
            if (prefixFreq.containsKey(key)) {
                count += prefixFreq.get(key);
            }
            prefixFreq.put(prefix, prefixFreq.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

}
