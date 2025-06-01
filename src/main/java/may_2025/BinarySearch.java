package may_2025;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(nums, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = (r + l) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (target > nums[mid]) {
            return helper(nums, target, mid + 1, r);
        } else {
            return helper(nums, target, l, mid - 1);
        }
    }

    public int search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2; // l + (r - l) / 2
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) { // > suggest direction
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}
