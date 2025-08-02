package july_2025;

import java.util.HashMap;
import java.util.Map;

public class SubArrSumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;

        SubArrSumEqualsK subArrSumEqualsK = new SubArrSumEqualsK();
        int result = subArrSumEqualsK.subarraySum(nums, k);
        System.out.println(result);
    }

    // Intuition:
    // - brute force - nested loops
    // Approach:
    // - precompute some prefix
    // count freq of appearance
    // Complexity:
    // O(n) time | O(n) space
    // Code:

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        int currSum = 0;
        int res = 0;
        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            res += freqMap.getOrDefault(diff, 0);
            freqMap.put(currSum, freqMap.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }


}
