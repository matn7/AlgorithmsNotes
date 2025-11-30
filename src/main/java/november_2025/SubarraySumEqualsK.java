package november_2025;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;

        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int result = subarraySumEqualsK.subarraySum(nums, k);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int curSum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;
            res += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }

}
