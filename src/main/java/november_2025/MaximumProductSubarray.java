package november_2025;

public class MaximumProductSubarray {

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {
        int curMin = 1;
        int curMax = 1;
        int res = nums[0];

        for (int num : nums) {

            int temp = num * curMax;
            curMax = Math.max(num, Math.max(num * curMin, num * curMax));
            curMin = Math.min(num, Math.min(temp, num * curMin));

            res = Math.max(res, curMax);
        }

        return res;
    }

}
