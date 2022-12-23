package udemy.faang.leetcode;


public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {1, 8, 8, 8, 8, 8, 8};

        SearchRange searchRange = new SearchRange();
        int[] result = searchRange.searchRange(nums, 8);
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums.length == 0) {
            return result;
        }

        int leftIdx = binarySearch(nums, target, false);
        int rightIdx = binarySearch(nums, target, true);

        result[0] = leftIdx;
        result[1] = rightIdx;

        return result;
    }

    private int binarySearch(int[] nums, int target, boolean goRight) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (goRight) {
                    if (mid == nums.length - 1) {
                        return mid;
                    } else if (nums[mid + 1] != target) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (mid == 0) {
                        return mid;
                    } else if (nums[mid - 1] != target) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
