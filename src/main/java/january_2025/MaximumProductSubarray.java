package january_2025;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};

        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int result = maximumProductSubarray.maxProduct(nums);
        System.out.println(result);
    }

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1;
        int curMax = 1;

        for (int num : nums) {
            int tmp = num * curMax;
            curMax = Math.max(num, Math.max(curMax * num, curMin * num));
            curMin = Math.min(num, Math.min(curMin * num, tmp));
            res = Math.max(res, curMax);
        }

        return res;
    }

}
