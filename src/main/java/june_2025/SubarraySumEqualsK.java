package june_2025;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        int curSum = 0;
        int res = 0;
        Map<Integer, Integer> freqSum = new HashMap<>();
        freqSum.put(0, 1);

        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;
            res += freqSum.getOrDefault(diff, 0);
            freqSum.put(curSum, freqSum.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }

}
