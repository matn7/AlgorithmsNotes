package july_2025;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(nums, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        return helper(nums, target, l, r);
    }

    private int helper(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (target == nums[m]) {
            return m;
        } else if (target > nums[m]) {
            return helper(nums, target, m + 1, r);
        } else {
            return helper(nums, target, l, m - 1);
        }
    }

}
