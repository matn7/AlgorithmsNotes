package september_2024;

public class ShiftedBinarySearch {

    public static void main(String[] args) {
        int[] nums = {45, 61, 71, 72, -73, 0, 1, 21, 33, 37, 39};
        int target = 45;

        System.out.println(shiftedBinarySearch(nums, target));
        System.out.println(shiftedBinarySearchRec(nums, target));
    }

    // O(log(n)) time | O(1) space
    public static int shiftedBinarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] < nums[mid]) {
                if (nums[start] <= target && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[end] >= target && nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    // O(log(n)) time | O(log(n)) space
    public static int shiftedBinarySearchRec(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return shiftedBinarySearchRecHelper(nums, target, 0, nums.length - 1);
    }

    private static int shiftedBinarySearchRecHelper(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[start] < nums[mid]) {
            if (nums[start] <= target && nums[mid] > target) {
                return shiftedBinarySearchRecHelper(nums, target, start, mid - 1);
            } else {
                return shiftedBinarySearchRecHelper(nums, target, mid + 1, end);
            }
        } else {
            if (nums[end] >= target && nums[mid] < target) {
                return shiftedBinarySearchRecHelper(nums, target, mid + 1, end);
            } else {
                return shiftedBinarySearchRecHelper(nums, target, start, mid - 1);
            }
        }

    }

}
