package september_2025;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        JumpGameII jumpGameII = new JumpGameII();
        int result = jumpGameII.jump(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jump = 1;
        int steps = nums[0];
        int maxReach = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            steps--;
            if (steps == 0) {
                steps = maxReach - i;
                jump++;
            }
        }
        return jump;
    }

}
