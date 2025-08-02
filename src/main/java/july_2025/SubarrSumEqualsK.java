package july_2025;

import java.util.HashMap;
import java.util.Map;

public class SubarrSumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;

        SubarrSumEqualsK subarrSum = new SubarrSumEqualsK();
        int result = subarrSum.subarraySum(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int res = 0;
        int currSum = 0;
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
