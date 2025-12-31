package december_2025;

public class MaxProductSubarray {

    public static void main(String[] args) {
//        int[] nums = {2,3,-2,4};
//        int[] nums = {-2, 0, -1};

        int[] nums = {-2,3,-4};

        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();
        int result = maxProductSubarray.maxProduct(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {
        int maxRes = nums[0];
        int curMin = 1;
        int curMax = 1;

        for (int i = 0; i < nums.length; i++) {

            int temp = curMax * nums[i];
            curMax = Math.max(curMax * nums[i], Math.max(curMin * nums[i], nums[i]));
            curMin = Math.min(curMin * nums[i], Math.min(temp, nums[i]));

            maxRes = Math.max(maxRes, curMax);
        }

        return maxRes;
    }

}
