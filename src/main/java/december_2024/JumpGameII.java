package december_2024;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 1, 1, 1};
//        int[] nums = {2,3,0,1,4};
        JumpGameII jumpGameII = new JumpGameII();
        int result = jumpGameII.jump(nums);
        System.out.println(result);
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jumps = 0;
        int reach = nums[0];
        int maxReach = nums[0];
        // index
        for (int pos = 1; pos < nums.length - 1; pos++) {
            int n = nums[pos];
            maxReach = Math.max(maxReach, n + pos);
            reach--;
            if (reach == 0) {
                reach = maxReach - pos;
                jumps++;
            }
        }

        return jumps + 1;
    }


    public int jump2(int[] nums) {
        int res = 0;
        int l = 0;
        int r = 0;

        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i < r + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }

}
