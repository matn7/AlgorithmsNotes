package june_2025;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-1};

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int result = maximumSubarray.maxSubArray(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int globalMax = Integer.MIN_VALUE;
        int maxInclude;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxInclude = Math.max(sum, num);
            if (sum < 0) {
                sum = 0;
            }
            globalMax = Math.max(globalMax, maxInclude);
        }
        return globalMax;
    }

}
