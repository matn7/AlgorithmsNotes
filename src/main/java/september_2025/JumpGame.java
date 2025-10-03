package september_2025;

public class JumpGame {

    public static void main(String[] args) {
//        int[] nums = {3,2,1,0,4};
        int[] nums = {2,3,1,1,4};
        JumpGame jumpGame = new JumpGame();
        boolean result = jumpGame.canJump(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int reach = 0;

        for (int pos = 0; pos < nums.length - 1; pos++) {
            int currReach = pos + nums[pos];
            reach = Math.max(reach, currReach);
            if (reach == pos) {
                return false;
            }
            if (reach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
