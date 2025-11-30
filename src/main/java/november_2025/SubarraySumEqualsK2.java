package november_2025;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;

        SubarraySumEqualsK2 subarraySumEqualsK2 = new SubarraySumEqualsK2();
        int result = subarraySumEqualsK2.subarraySum(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            if (prefixSums.containsKey(prefixSum - k)) {
                count += prefixSums.get(prefixSum - k);
            }
            prefixSums.put(prefixSum, prefixSums.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

}
