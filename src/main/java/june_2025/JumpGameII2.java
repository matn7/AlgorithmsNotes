package june_2025;

public class JumpGameII2 {

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {2,3,0,1,4};

        JumpGameII2 jumpGameII2 = new JumpGameII2();
        int result = jumpGameII2.jump(nums);
        System.out.println(result);
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int jumps = 1;
        int reach = nums[0];
        int maxReach = 0;
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
