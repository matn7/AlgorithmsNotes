package january_2026;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};

        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int result = maxConsecutiveOnes.findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int L = 0;
        int R = 0;
        int maxLen = 0;

        while (R < nums.length && L < nums.length) {
            while (R < nums.length && L < nums.length && nums[L] != 1 && nums[R] != 1) {
                L++;
                R++;
            }

            while (R < nums.length && nums[R] == 1) {
                R++;
            }
            maxLen = Math.max(maxLen, R - L);
            L = R;
        }
        return maxLen;
    }


}
