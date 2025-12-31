package december_2025;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();
        int result = maximumSubarraySum.maxSubArray(nums);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxHere = 0;

        for (int i = 0; i < nums.length; i++) {
            maxHere = Math.max(nums[i], maxHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxHere);
        }

        return maxSoFar;
    }

}
