package coderpro;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        productOfArrayExceptSelf.productExceptSelf(nums);
    }

    // O(n) time | O(n) space
    public int[] productExceptSelf(int[] nums) {
        int[] right = new int[nums.length];
        Arrays.fill(right, 1);
        int prod = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            right[i] = prod;
        }

        prod = 1;
        for (int i = 1; i < nums.length; i++) {
            prod *= nums[i - 1];
            right[i] *= prod;
        }

        return right;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] right = new int[nums.length];

        int r = 1;
        for (int i = 0; i < nums.length; i++) {
            right[i] = r;
            r *= nums[i];
        }

        int[] left = new int[nums.length];
        int l = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            left[i] = l;
            l *= nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;

    }

}
