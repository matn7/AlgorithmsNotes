package april_2025;

public class SearchRange {

    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = {8, 8, 8, 10};
        int target = 8;

        SearchRange searchRange = new SearchRange();
        int[] result = searchRange.searchRange(nums, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false);
        return new int[] {leftIdx, rightIdx};
    }

    private int binarySearch(int[] nums, int target, boolean toLeft) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int M = (L + R) / 2; // (L + (R - L) / 2)
            if (nums[M] == target) {
                if (toLeft) {
                    if (M == 0 || nums[M - 1] != target) {
                        return M;
                    } else {
                        R = M - 1;
                    }
                } else {
                    if (M == nums.length - 1 || nums[M + 1] != target) {
                        return M;
                    } else {
                        L = M + 1;
                    }
                }
            } else if (target > nums[M]) {
                L = M + 1;
            } else {
                R = M - 1;
            }

        }
        return -1;
    }

}
