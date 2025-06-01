package may_2025;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        SubarraySum subarraySum = new SubarraySum();
        int result = subarraySum.subarraySum(nums, k);
        System.out.println(result);
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int prefix = 0;
        int result = 0;
        for (int num : nums) {
            prefix += num;
            int sum = prefix - k;
            if (counts.containsKey(sum)) {
                result += counts.get(sum);
            }
            counts.put(prefix, counts.getOrDefault(prefix, 0) + 1);
        }
        return result;
    }



    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
            counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            counts.put(prefixSum[i - 1], counts.getOrDefault(prefixSum[i - 1], 0) + 1);
        }
        return counts.getOrDefault(k, 0);
    }

}
