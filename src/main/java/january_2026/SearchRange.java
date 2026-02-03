package january_2026;

public class SearchRange {

    public static void main(String[] args) {
//        int[] nums = {5,7,7,8,8,10};
//        int target = 8;
//        int[] nums = {5,7,7,8,8,10};
//        int target = 6;

        int[] nums = {};
        int target = 0;

        SearchRange searchRange = new SearchRange();
        int[] result = searchRange.searchRange(nums, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = helper(nums, target, true);
        if (leftIdx == -1) {
            return new int[] {-1, -1};
        }
        int rightIdx = helper(nums, target, false);
        return new int[] {leftIdx, rightIdx};
    }

    private int helper(int[] nums, int target, boolean goLeft) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                // found elements
                if (goLeft) {
                    if (mid == 0) {
                        return mid;
                    }
                    if (nums[mid - 1] < nums[mid]) {
                        return mid;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1) {
                        return mid;
                    }
                    if (nums[mid + 1] > nums[mid]) {
                        return mid;
                    }  else {
                        l = mid + 1;
                    }
                }
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }


}
