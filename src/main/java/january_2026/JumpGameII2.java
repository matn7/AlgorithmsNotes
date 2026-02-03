package january_2026;

public class JumpGameII2 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        JumpGameII jumpGameII = new JumpGameII();
        int result = jumpGameII.jump(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums[0] == 0) {
            return -1;
        }

        int jumps = 1;
        int maxReach = nums[0];
        int reach = maxReach;

        for (int i = 1; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            reach--;
            if (reach == 0) {
                jumps++;
                reach = maxReach - i;
            }
        }
        return jumps;
    }

}
