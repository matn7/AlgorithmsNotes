package october_2023;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res1 = maximumSubarray(nums);
        int res2 = maximumSubarray2(nums);
        System.out.println(res1);
        System.out.println(res2);
    }

    // O(n) time | O(1) space
    public static int maximumSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            } else {
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    // O(n^2) time | O(1) space
    public static int maximumSubarray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int other = nums[j];
                sum += other;
                max = Math.max(max, sum);
            }
        }

        return max;
    }

}
