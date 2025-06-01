package may_2025;

public class ProductExceptSelf {

    // O(n) time | O(n) space
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= prod;
            prod *= nums[i];
        }

        return result;
    }

}
