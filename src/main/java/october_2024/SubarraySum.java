package october_2024;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {
//        int[] nums = {1, 1, -1, -1, 1, 1, 1};
        int[] nums = {1, 2, 3};

        SubarraySum subarraySum = new SubarraySum();
        int result = subarraySum.subarraySum(nums, 3);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int curSum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for (int n : nums) {
            curSum += n;
            int diff = curSum - k;

            res += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
        }

        return res;
    }

    // O(n^2) time | O(1) space
    public int subarraySum2(int[] nums, int k) {
        // [1, 1, -1, -1, 1, 1, 1]
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

}
