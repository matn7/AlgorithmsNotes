package july_2025;

import java.util.HashMap;
import java.util.Map;

public class SubArrSum {

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int curSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;
            res += freq.getOrDefault(diff, 0);
            freq.put(curSum, freq.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }

}
