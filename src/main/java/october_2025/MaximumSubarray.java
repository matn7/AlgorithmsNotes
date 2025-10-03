package october_2025;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int result = maximumSubarray.maxSubArray(nums);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxHere = 0;
        for (int num : nums) {
            maxHere = Math.max(num, maxHere + num);

            maxSoFar = Math.max(maxSoFar, maxHere);
        }

        return maxSoFar;
    }

}
