package june_2025;

public class MaxProductSub {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};

        MaxProductSub maxProductSub = new MaxProductSub();
        int result = maxProductSub.maxProduct(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int curMax = 1;
        int curMin = 1;

        for (int num : nums) {
            int temp = num * curMax;
            curMax = Math.max(num, Math.max(num * curMax, num * curMin));
            curMin = Math.min(num, Math.min(temp, num * curMin));
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }


}
