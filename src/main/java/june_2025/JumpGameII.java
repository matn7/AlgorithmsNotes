package june_2025;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        JumpGameII jumpGameII = new JumpGameII();
        int result = jumpGameII.jump(nums);
        System.out.println(result);
    }

    public int jump(int[] nums) {
        int jumps = 0;
        int maxReach = nums[0];
        int steps = maxReach;
        for (int i = 1; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReach;
            }
        }
        return jumps + 1;
    }

}
