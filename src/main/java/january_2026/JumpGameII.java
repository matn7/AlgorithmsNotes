package january_2026;

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
        int jumps = 1;

        int reach = nums[0];
        int dist = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            reach--;
            dist = Math.max(dist, i + nums[i]);
            if (reach == 0) {
                jumps++;
                reach = dist - i;
            }
        }

        return jumps;
    }

}
