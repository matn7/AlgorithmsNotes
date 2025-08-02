package july_2025;

import java.util.Arrays;

public class ProdOfArrExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProdOfArrExceptSelf prodOfArrExceptSelf = new ProdOfArrExceptSelf();
        int[] result = prodOfArrExceptSelf.productExceptSelf(nums);
        System.out.println(result);
    }

    // Intuition:
    // - nested loops, prod except curr idx
    // - multiple pass through arr?
    // Approach:
    // - calc prod once left to right, and then from right to left
    // Complexity:
    // - O(n) time | O(n) space
    // Code:

    public int[] productExceptSelf(int[] nums) {
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
