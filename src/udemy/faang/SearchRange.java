package udemy.faang;

public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 5, 5, 5, 8, 9};
        SearchRange searchRange = new SearchRange();
        searchRange.searchRange(nums, 5);
    }

    // O(log(n)) time | O(1) space
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        int firstPos = binarySearch(nums, 0, nums.length - 1, target);
        if (firstPos == -1) {
            return new int[] {-1, -1};
        }
        int startPos = firstPos;
        int endPos = firstPos;
        int temp1 = 0;
        int temp2 = 0;
        while (startPos != -1) {
            temp1 = startPos;
            startPos = binarySearch(nums, 0, startPos - 1, target);
        }
        startPos = temp1;
        while (endPos != -1) {
            temp2 = endPos;
            endPos = binarySearch(nums, endPos + 1, nums.length - 1, target);
        }
        endPos = temp2;
        return new int[] {startPos, endPos};
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
