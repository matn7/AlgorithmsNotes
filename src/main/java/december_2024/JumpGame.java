package december_2024;

public class JumpGame {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 0, 1, 0};
        int[] nums = {1, 2, 1, 0, 1};
        JumpGame jumpGame = new JumpGame();
        boolean result = jumpGame.canJump(nums);
        System.out.println(result);
    }

    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int pos = 0; pos < nums.length; pos++) {
            if (pos > maxReach) {
                return false;
            }
            int n = nums[pos];
            int reach = pos + n;
            maxReach = Math.max(maxReach, reach);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
