package april_2025;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] result = productOfArrayExceptSelf.productExceptSelf(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
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
