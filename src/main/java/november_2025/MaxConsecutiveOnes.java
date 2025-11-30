package november_2025;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 0, 1, 1, 1};
        int[] nums = {0};

        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int result = maxConsecutiveOnes.findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int findMaxConsecutiveOnes(int[] nums) {
        int L = 0;
        int R = 0;
        int maxLen = 0;

        while (R < nums.length) {
            L = R;
            while (R < nums.length && nums[R] == nums[L] && nums[R] == 1) {
                R++;
                maxLen = Math.max(maxLen, R - L);
            }
            while (R < nums.length && nums[R] == 0) {
                R++;
            }
        }
        return maxLen;
    }

}
