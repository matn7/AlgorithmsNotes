package october_2024;

public class HouseRobberyII {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {2, 3, 2};
//        int[] nums = {1,2,1,1};

        HouseRobberyII houseRobberyII = new HouseRobberyII();
        int rob = houseRobberyII.rob(nums);
        System.out.println(rob);
    }

    // leetcode 213

    // O(n) time | O(n) space
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];

        System.arraycopy(nums, 0, nums1, 0, nums.length - 1);
        System.arraycopy(nums, 1, nums2, 0, nums.length - 1); // Corrected index here

        return Math.max(helper(nums1), helper(nums2)); // Removed nums[0] case
    }

    private int helper(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for (int n : nums) {
            int newRob = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }

}
