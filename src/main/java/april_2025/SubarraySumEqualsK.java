package april_2025;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;

//        int[] nums = {1, 1, 1};
//        int k = 2;

//        int[] nums = {1};
//        int k = 0;

        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int result = subarraySumEqualsK.subarraySum(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int res = 0;
        int currSum = 0;

        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            res += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }

}
