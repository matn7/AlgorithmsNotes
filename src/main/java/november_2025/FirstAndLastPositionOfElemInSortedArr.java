package november_2025;

public class FirstAndLastPositionOfElemInSortedArr {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        FirstAndLastPositionOfElemInSortedArr search = new FirstAndLastPositionOfElemInSortedArr();
        int[] ints = search.searchRange(nums, target);
        System.out.println(ints);
    }

    // O(log(n)) time | O(1) space
    public int[] searchRange(int[] nums, int target) {

        int leftIdx = search(nums, target, true);
        int rightIdx = search(nums, target, false);

        return leftIdx != -1 ? new int[] {leftIdx, rightIdx} : new int[] {-1, -1};

    }

    private int search(int[] nums, int target, boolean searchLeft) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                // search
                if (searchLeft) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    } else {
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
