package leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        productOfArrayExceptSelf.productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {

        int[] product = new int[nums.length];
        Arrays.fill(product, 1);

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            product[i] = left;
            left = left * nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product[i] = product[i] * right;
            right = right * nums[i];
        }


        return product;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                l[i] = 1;
            } else {
                l[i] = l[i - 1] * nums[i - 1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                r[i] = 1;
            } else {
                r[i] = r[i + 1] * nums[i + 1];
            }
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = l[i] * r[i];
        }
        return output;
    }

}
