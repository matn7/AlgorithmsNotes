package october_2025;

public class BinarySearch {

    // O(log(n)) time | O(1) space
    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    private int helper(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (target == nums[m]) {
            return m;
        } else if (target > nums[m]) {
            return helper(nums, m + 1, r, target);
        } else {
            return helper(nums, l, m - 1, target);
        }
    }

}
