package september_2024;

public class HouseRobbery {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(result[i - 1], nums[i] + result[i - 2]);
        }
        return result[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int rob1 = 0;
        int rob2 = 0;

        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

}
