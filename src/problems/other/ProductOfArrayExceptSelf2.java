package problems.other;

import java.util.Arrays;

public class ProductOfArrayExceptSelf2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        ProductOfArrayExceptSelf2 productOfArrayExceptSelf2 = new ProductOfArrayExceptSelf2();
        productOfArrayExceptSelf2.productOfArray(nums);
        productOfArrayExceptSelf2.productOfArray2(nums);
    }

    public int[] productOfArray2(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = right;
            right *= nums[i]; // 2 * 3 = 6
        }

        int left = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= left;
            left *= nums[i];
        }

        return result;
    }

    public int[] productOfArray(int[] nums) {
        int[] result = new int[nums.length];

        int[] rightResult = new int[nums.length];
        int right = 1;
        //        *
        // [1, 2, 3, 4]
        for (int i = 0; i < nums.length; i++) {
            //           *
            // [1, 1, 2, 6]
            rightResult[i] = right;
            right *= nums[i]; // 2 * 3 = 6
        }

        int[] leftResult = new int[nums.length];
        int left = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            leftResult[i] = left;
            left *= nums[i];
        }

        for (int i = 0; i < result.length; i++) {
            int num = rightResult[i] * leftResult[i];
            result[i] = num;
        }

        return result;
    }

}
