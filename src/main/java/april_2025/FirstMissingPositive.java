package april_2025;

public class FirstMissingPositive {

    public static void main(String[] args) {
//        int[] nums = {3, 4, -1, 1};
//        int[] nums = {-3, -4, -1, -1};
//        int[] nums = {100000, 3, 4000, 2, 15, 1, 99999};
        int[] nums = {1};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int result = firstMissingPositive.firstMissingPositive(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= nums.length) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                } else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (nums.length + 1);
                }
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }
        return nums.length + 1;
    }

}
