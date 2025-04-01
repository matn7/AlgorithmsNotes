package february_2025;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        HouseRobber houseRobber = new HouseRobber();
        int rob = houseRobber.rob(nums);
        System.out.println(rob);
    }

    // O(n) time | O(n) space
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        cache[0] = nums[0];
        cache[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            cache[i] = Math.max(cache[i - 1], nums[i] + cache[i - 2]);
        }
        return cache[cache.length - 1];
    }

}
