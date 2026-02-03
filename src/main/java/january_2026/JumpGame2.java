package january_2026;

public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        JumpGame2 jumpGame2 = new JumpGame2();
        boolean result = jumpGame2.canJump(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean canJump(int[] nums) {
        int destination = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= destination) {
                destination = i;
            }
        }

        return destination == 0;
    }

    public boolean canJump2(int[] nums) {
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
            if (maxReach <= i) {
                return false;
            }
        }
        return false;
    }

}
