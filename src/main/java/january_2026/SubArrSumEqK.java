package january_2026;

import java.util.HashMap;
import java.util.Map;

public class SubArrSumEqK {

    // prefix += num
    // key = prefix - k

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefix = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        for (int num : nums) {
            prefix += num;
            int key = prefix - k;
            if (freqMap.containsKey(key)) {
                count += freqMap.get(key);
            }
            freqMap.put(prefix, freqMap.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

}
