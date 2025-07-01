package june_2025;

public class MaxProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};

        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();
        int result = maxProductSubarray.maxProduct(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1;
        int curMin = 1;

        for (int num : nums) {
            int temp = curMax * num;
            curMax = Math.max(curMax * num, Math.max(curMin * num, num));
            curMin = Math.min(curMin * num, Math.min(temp, num));
            res = Math.max(res, curMax);
        }
        return res;
    }

}
