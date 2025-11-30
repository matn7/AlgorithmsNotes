package november_2025;

import java.util.Arrays;

public class ProductArrayWithoutCurrentElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ProductArrayWithoutCurrentElement prod = new ProductArrayWithoutCurrentElement();
        int[] result = prod.productExceptSelf(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prod;
            prod *= res[i];
        }

        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= prod;
            prod *= res[i];
        }
        return res;
    }

}
