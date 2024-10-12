package leetcode;

public class SearchInRotatesSortedArray {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] < nums[mid]) {
                // left subnums sorted
                if (nums[start] == target) {
                    return start;
                } else if (nums[start] > target) {
                    start = mid + 1;
                } else {
                    if (nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            } else {
                if (nums[end] == target) {
                    return end;
                } else if (nums[end] < target) {
                    end = mid - 1;
                } else {
                    if (nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

}
