package january_2026;

public class JumpGame {

    public static void main(String[] args) {
        // int[] nums = {2,3,1,1,4};

        int[] nums = {3,2,1,0,4};

        JumpGame jumpGame = new JumpGame();
        boolean result = jumpGame.canJump(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int maxReach = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
            if (maxReach == i) {
                return false;
            }
        }
        return false;
    }


}
