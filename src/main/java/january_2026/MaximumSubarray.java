package january_2026;

public class MaximumSubarray {

    public static void main(String[] args) {
        // int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int[] nums = {5,4,-1,7,8};

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int result = maximumSubarray.maxSubArray(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxSubArray(int[] nums) {
        int maxHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxHere = Math.max(maxHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxHere, maxSoFar);
        }
        return maxSoFar;
    }

}
