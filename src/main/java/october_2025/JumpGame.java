package october_2025;

public class JumpGame {

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};

        JumpGame jumpGame = new JumpGame();
        boolean result = jumpGame.canJump(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
