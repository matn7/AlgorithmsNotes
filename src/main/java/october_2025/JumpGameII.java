package october_2025;

public class JumpGameII {

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {2,3,0,1,4};
        int[] nums = {1, 2};

        JumpGameII jumpGameII = new JumpGameII();
        int result = jumpGameII.jump(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jumps = 0;
        int steps = nums[0];
        int maxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
            steps--;
        }
        return jumps + 1;
    }


}
