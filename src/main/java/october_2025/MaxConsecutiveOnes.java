package october_2025;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};

        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int result = maxConsecutiveOnes.findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 1;
        int cur = 1;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 1) {
                cur++;
            } else {
                cur = 1;
            }
            maxLen = Math.max(maxLen, cur);
        }
        return maxLen;
    }

}
