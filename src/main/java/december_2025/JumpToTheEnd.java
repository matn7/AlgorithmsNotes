package december_2025;

public class JumpToTheEnd {

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int reach = nums[0];
        int maxReach = reach;
        int jump = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            reach--;
            if (reach == 0) {
                jump++;
                reach = maxReach - i;
            }
        }
        return jump;
    }


}
