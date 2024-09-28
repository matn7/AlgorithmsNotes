package august_2024;

public class JumpToTheEnd {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 1, 9, 3, 4};

        int result = jumpToEnd(nums);
        System.out.println(result);
    }

    public static int jumpToEnd(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxReach = nums[0];
        int steps = maxReach;
        int jumps = 0;
        for (int i = 1; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            steps--;
            if (steps == 0) {
                steps = maxReach - i;
                jumps++;
            }
        }
        return jumps;
    }

}
