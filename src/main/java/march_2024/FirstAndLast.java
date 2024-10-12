package march_2024;

public class FirstAndLast {

    public static void main(String[] args) {
        int[] arr = {10, 11, 11, 11, 14, 15};
        int target = 11;

        searchRange(arr, target);
    }

    // O(log(n)) time | O(1) space
    public static int[] searchRange(int[] arr, int target) {
        int leftIdx = searchRangeHelper(arr, target, true);
        int rightIdx = searchRangeHelper(arr, target, false);
        return new int[] {leftIdx, rightIdx};
    }

    private static int searchRangeHelper(int[] arr, int target, boolean searchLeft) {
        // [10, 11, 11, 11, 14, 15]
        //   L       M           R
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                if (searchLeft) {
                    // LEFT
                    if (mid == 0 || arr[mid - 1] != target) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // RIGHT
                    if (mid == arr.length - 1 || arr[mid + 1] != target) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
