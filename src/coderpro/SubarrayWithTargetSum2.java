package coderpro;

import java.util.ArrayList;
import java.util.List;

public class SubarrayWithTargetSum2 {

    public static void main(String[] args) {

        int[] nums = {1, 3, 2, 5, 7, 2};
        int k = 14;

        SubarrayWithTargetSum2 subarrayWithTargetSum2 = new SubarrayWithTargetSum2();
        subarrayWithTargetSum2.subarray(nums, k);
    }

    // O(n) time | O(n) space
    public List<Integer> subarray(int[] nums, int target) {
        int start = 0;
        int end = 0;
        int sum = 0;

        //              e
        // [1, 3, 2, 5, 7, 2], 14
        //        s
        while (end < nums.length) {
            int curr = nums[end]; // 7
            if (sum + curr == target) {
                break;
            } else if (sum + curr < target) {
                sum += curr; // 7
                end++;
            } else {
                sum -= nums[start];
                start++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int s = start; s <= end; s++) {
            result.add(nums[s]);
        }
        return result;
    }

}
