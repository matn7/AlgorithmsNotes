package june_2025;

public class JumpGame2 {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3,2,1,0,4};
        int[] nums = {1, 2, 3};
        JumpGame2 jumpGame2 = new JumpGame2();
        boolean result = jumpGame2.canJump(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean canJump(int[] nums) {
        int pos = 0;
        int reach = 0;
        while (pos < nums.length) {
            if (pos > reach) {
                return false;
            }
            reach = Math.max(reach, pos + nums[pos]);
            if (reach >= nums.length - 1) {
                return true;
            }
            pos++;
        }
        return false;
    }

}
