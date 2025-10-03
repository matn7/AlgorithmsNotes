package september_2025;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};

        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int result = maximumProductSubarray.maxProduct(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int curMin = 1;
        int curMax = 1;

        for (int n : nums) {
            int temp = n * curMax;
            curMax = Math.max(n, Math.max(n * curMax, n * curMin));
            curMin = Math.min(n, Math.min(temp, n * curMin));
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }



}
