package coderpro;

public class OptimizedListSum2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] range = {2, 5};
        OptimizedListSum2 optimizedListSum2 = new OptimizedListSum2();
        int result = optimizedListSum2.optimizedListSum(nums, range);
        System.out.println(result);
    }

    public int optimizedListSum(int[] nums, int[] range) {
        int[] sums = new int[nums.length];

        sums[0] = nums[0];
        // 1, 0, 0, 0, 0, 0, 0
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        if (range[0] == 0) {
            return sums[range[1] - 1];
        }

        return sums[range[1] - 1] - nums[range[0]];
    }

}
