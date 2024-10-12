package october_2024;

public class MaxProductSubarray {

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
        int[] nums = {-1, -2, -3};

        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();
        int result = maxProductSubarray.maxProduct(nums);
        System.out.println(result);
    }

    // leetcode 152

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {

        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            res = Math.max(res, num);
        }

        int currMin = 1;
        int currMax = 1;

        for (int n : nums) {
            int tmp = currMax * n;
            currMax = Math.max(n * currMax, Math.max(n * currMin, n));
            currMin = Math.min(tmp, Math.min(n * currMin, n));
            res = Math.max(res, currMax);
        }

        return res;
    }

}
