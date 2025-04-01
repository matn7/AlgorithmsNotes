package december_2024;

public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {1, 2, -3, 4};
//        int[] nums = {2, 3, -2, 4};
//        int[] nums = {-2, 0, -1};

        MaxProduct maxProduct = new MaxProduct();
        int result = maxProduct.maxProduct(nums);
        System.out.println(result);
    }

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int n : nums) {
            res = Math.max(res, n);
        }
        int curMin = 1;
        int curMax = 1;

        for (int n : nums) {
            int temp = curMax * n;
            curMax = Math.max(n * curMax, Math.max(n * curMin, n));
            curMin = Math.min(temp, Math.min(n * curMin, n));
            res = Math.max(res, curMax);
        }
        return res;
    }

}
