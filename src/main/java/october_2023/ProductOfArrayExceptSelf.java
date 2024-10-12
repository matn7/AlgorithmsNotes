package october_2023;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        productOfArray(nums);
    }

    // O(n) time | O(n) space
    public static int[] productOfArray(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
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
