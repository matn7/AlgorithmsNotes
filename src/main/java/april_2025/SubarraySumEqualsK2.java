package april_2025;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK2 {

    public static void main(String[] args) {
        int[] nums = {1, -1, 1, 1, 1, 1};
        int k = 3;

        SubarraySumEqualsK2 subarraySumEqualsK2 = new SubarraySumEqualsK2();
        int result = subarraySumEqualsK2.subarraySum(nums, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int key = sum - k;
            if (prefixSum.containsKey(key)) {
                res += prefixSum.get(key);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

}
