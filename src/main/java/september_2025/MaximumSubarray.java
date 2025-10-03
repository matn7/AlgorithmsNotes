package september_2025;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int result = maximumSubarray.maxSubArray(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = 0;
        for (int num : nums) {
            curr = Math.max(curr + num, num);
            max = Math.max(max, curr);
        }
        return max;
    }

}
