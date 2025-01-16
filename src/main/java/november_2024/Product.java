package november_2024;

import java.util.Arrays;

public class Product {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        Product product = new Product();
        int[] ints = product.productExceptSelf(nums);
        System.out.println(ints);
    }

    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] products = new int[nums.length];
        Arrays.fill(products, 1);
        for (int i = 0; i < nums.length; i++) {
            products[i] = prod;
            prod *= nums[i];
        }

        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            products[i] *= prod;
            prod *= nums[i];
        }
        return products;
    }

}
