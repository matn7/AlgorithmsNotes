package september_2024;

public class TwoSumII {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 7, 10, 11};
        int target = 9;

        TwoSumII twoSumII = new TwoSumII();
        int[] result = twoSumII.twoSum(nums, target);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return new int[] {start + 1, end + 1};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[] {};
    }

}
