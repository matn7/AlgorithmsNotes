package april_2025;

public class MaxProductSubarray {

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int n : nums) {
            res = Math.max(res, n);
        }
        int curMin = 1;
        int curMax = 1;

        for (int n : nums) {
            if (n == 0) {
                curMin = 1;
                curMax = 1;
                continue;
            }
            int tmp = curMax * n;
            curMax = Math.max(n * curMax, Math.max(n * curMin, n));
            curMin = Math.min(tmp, Math.min(n * curMin, n));
            res = Math.max(res, curMax);
        }
        return res;
    }

}
