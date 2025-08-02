package july_2025;

public class Product2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Product2 product2 = new Product2();
        int[] result = product2.productExceptSelf(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
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
