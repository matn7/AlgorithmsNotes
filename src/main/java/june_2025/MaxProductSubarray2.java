package june_2025;

public class MaxProductSubarray2 {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        MaxProductSubarray2 maxProductSubarray2 = new MaxProductSubarray2();
        int result = maxProductSubarray2.maxProduct(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1;
        int curMax = 1;

        for (int num : nums) {
            int temp = curMax * num;
            curMax = Math.max(num, Math.max(curMax * num, curMin * num));
            curMin = Math.max(num, Math.min(curMin * num, temp));
            res = Math.max(res, curMax);
        }
        return res;
    }


}
