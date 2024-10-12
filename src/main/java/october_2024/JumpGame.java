package october_2024;

public class JumpGame {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};

//        int[] nums = {3, 2, 1, 0, 4};

//        int[] nums = {1, 2, 3};

        int[] nums = {1, 1, 1, 0};

        JumpGame jumpGame = new JumpGame();
        boolean result = jumpGame.canJump(nums);
        System.out.println(result);
    }

    // leetcode 55

    // O(n) time | O(1) space
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // Cannot reach this index
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true; // Can reach the last index
            }
        }
        return false;
    }

    // O(n) time | O(1) space
    public boolean canJump2(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }

}
