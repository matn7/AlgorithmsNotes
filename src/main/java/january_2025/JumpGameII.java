package january_2025;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        JumpGameII jumpGameII = new JumpGameII();
        int result = jumpGameII.jump(nums);
        System.out.println(result);
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jumps = 0;
        int maxReach = nums[0];
        int steps = maxReach;

        for (int i = 1; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }

        return jumps + 1;
    }

}
