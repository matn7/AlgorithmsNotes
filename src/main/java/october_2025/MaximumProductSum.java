package october_2025;

public class MaximumProductSum {

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {
        int curMin = 1;
        int curMax = 1;
        int result = nums[0];

        for (int num : nums) {
            int temp = num * curMax;
            curMax = Math.max(num, Math.max(num * curMax, num * curMin));
            curMin = Math.min(num, Math.min(temp, num * curMin));
            result = Math.max(result, curMax);
        }
        return result;
    }

}
