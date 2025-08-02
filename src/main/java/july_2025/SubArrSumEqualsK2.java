package july_2025;

import java.util.HashMap;
import java.util.Map;

public class SubArrSumEqualsK2 {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;

        SubArrSumEqualsK2 subArrSumEqualsK2 = new SubArrSumEqualsK2();
        int result = subArrSumEqualsK2.subarraySum(nums, k);
        System.out.println(result);
    }

    // Intuition:
    // - subarray - contiguous
    // - brute force -> nested loops O(n^2)
    // - precompute, subarr use Kadane's?
    // Approach:
    // - Counts occur of subsum
    // - keep increasing res as loop
    // Complexity:
    // O(n) time | O(n) space
    // Code:

    // [1, 1, 1]
    //  1
    //     2
    //        3
    //     1
    //        2
    //        1
    // counts = {0:1, 1:1, 2:1, 3:1}
    // whether wer already calculates query before?
    // curSum = 3
    // diff = curSum - k == 3 - 2 = 1

    // res = 2
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int res = 0;
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;
            res += counts.getOrDefault(diff, 0);
            counts.put(curSum, counts.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }

}
