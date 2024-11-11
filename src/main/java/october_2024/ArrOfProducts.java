package october_2024;

import java.util.Arrays;

public class ArrOfProducts {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ArrOfProducts arrOfProducts = new ArrOfProducts();
        int[] result = arrOfProducts.productExceptSelf(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prod;
            prod *= nums[i];
        }

        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= prod;
            prod *= nums[i];
        }
        return res;
    }


}
