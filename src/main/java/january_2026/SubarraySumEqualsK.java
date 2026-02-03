package january_2026;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;

        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int result = subarraySumEqualsK.subarraySum(nums, k);
        System.out.println(result);
    }

    // key = prefix - key
    // prefix += num

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int count = 0;
        int prefix = 0;
        for (int num : nums) {
            prefix += num;
            int key = prefix - k;
            if (prefixSum.containsKey(key)) {
                count += prefixSum.get(key);
            }
            prefixSum.put(prefix, prefixSum.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

}
