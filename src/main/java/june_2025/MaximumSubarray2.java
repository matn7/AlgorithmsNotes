package june_2025;

public class MaximumSubarray2 {

    public static void main(String[] args) {
        int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums= {-2, -1};

        MaximumSubarray2 maximumSubarray2 = new MaximumSubarray2();
        int result = maximumSubarray2.maxSubArray(nums);

        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int maxSubArray(int[] nums) {
        int global = nums[0];
        int here = 0;
        for (int num : nums) {
            here += num;
            here = Math.max(here, num);
            global = Math.max(global, here);
        }

        return global;
    }

}
