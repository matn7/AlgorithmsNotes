package october_2025;

public class MaximumSubarray2 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        MaximumSubarray2 maximumSubarray2 = new MaximumSubarray2();
        int result = maximumSubarray2.maxSubArray(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxHere = 0;
        for (int num : nums) {
            maxHere = Math.max(num, num + maxHere);
            maxSoFar = Math.max(maxSoFar, maxHere);
        }
        return maxSoFar;
    }


}
