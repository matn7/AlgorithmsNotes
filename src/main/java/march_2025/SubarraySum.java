package march_2025;

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
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int res = 0;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            int diff = curSum - k;
            res += prefixCount.getOrDefault(diff, 0);
            prefixCount.put(curSum, prefixCount.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }

}
