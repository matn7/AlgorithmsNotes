package january_2026;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};

        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int result = firstMissingPositive.firstMissingPositive(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                } else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (n + 1); // does not affect solution
                }
            }
            System.out.println();
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }
        return n + 1;
    }
}
