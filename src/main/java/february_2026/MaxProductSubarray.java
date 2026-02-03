package february_2026;

public class MaxProductSubarray {

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMin = 1;
        int currMax = 1;

        for (int num : nums) {
            int temp = currMax * num;
            currMax = Math.max(num * currMax, Math.max(num * currMin, num));
            currMin = Math.min(temp, Math.min(num * currMin, num));
            res = Math.max(res, currMax);
        }
        return res;
    }


}
