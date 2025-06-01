package may_2025;

public class MaximumProductSubarray {

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
//        int[] nums = {-2,0,-1};
        int[] nums = {-1, -2, -9, 0, 3, 5};

        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int result = maximumProductSubarray.maxProduct(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int a = num * max;
            int b = num * min;
            max = Math.max(num, Math.max(a, b));
            min = Math.min(num, Math.min(a, b));

            res = Math.max(res, max);
        }

        return res;
    }

}
