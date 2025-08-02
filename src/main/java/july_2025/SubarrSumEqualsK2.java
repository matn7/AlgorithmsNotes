package july_2025;

import java.util.HashMap;
import java.util.Map;

public class SubarrSumEqualsK2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;

        SubarrSumEqualsK2 subarrSumEqualsK2 = new SubarrSumEqualsK2();
        int result = subarrSumEqualsK2.subarraySum(nums, k);
        System.out.println(result);
    }

    // Intuition:
    // - subarr - contiguous
    // brute force - nested loops
    // Approach:
    // - reuse calculated sums
    // Complexity:
    // - O(n) time | O(n) space
    // Code:

    // [1, 1, 1]
    //  *

    // currSum - k in counts
    // {1: 1, 2: 1, 3 : 1}

    public int subarraySum(int[] nums, int k) {
        int currSum = 0;
        int res = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            res += freqMap.getOrDefault(diff, 0);
            freqMap.put(currSum, freqMap.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }

}
