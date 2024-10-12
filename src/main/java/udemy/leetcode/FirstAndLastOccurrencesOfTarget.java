package udemy.leetcode;

public class FirstAndLastOccurrencesOfTarget {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        FirstAndLastOccurrencesOfTarget searchRange = new FirstAndLastOccurrencesOfTarget();
        int[] result = searchRange.searchRange(nums, target);
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false);
        return new int[] {start, end};
    }

    private int binarySearch(int[] nums, int target, boolean goLeft) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //          se  *
            // [5, 7, 7, 8, 8, 8, 8, 8 10]
            if (nums[mid] == target) {
                if (goLeft) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        start = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}

