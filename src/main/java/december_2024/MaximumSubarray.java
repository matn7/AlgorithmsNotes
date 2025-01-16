package december_2024;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int curSum = 0;

        for (int n : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += n;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;
    }

}
