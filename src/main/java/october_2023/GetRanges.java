package october_2023;

public class GetRanges {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 5, 7, 8, 9, 9, 9, 15};
        int target = 9;

        getRanges(nums, target);
    }

    // O(log(n)) time | O(1) space
    public static int[] getRanges(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = getRangesHelper(nums, target, true);
        res[1] = getRangesHelper(nums, target, false);
        return res;
    }

    private static int getRangesHelper(int[] nums, int target, boolean goLeft) {
        int start = 0;
        int end = nums.length - 1;

        //  0  1  2  3  4  5  6  7  8  9
        //                    e
        // [1, 3, 3, 5, 7, 8, 9, 9, 9, 15]
        //                    s
        //                       m
        while (start <= end) {
            int mid = (start + end) / 2; // 4
            if (nums[mid] == target) {
                if (goLeft) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    }
                    start = mid + 1;
                }
            } else if (nums[mid] < target) { // 7 < 9
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
