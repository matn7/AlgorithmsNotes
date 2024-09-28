package august_2024;

public class ShiftedBinarySearchV4 {

    public static void main(String[] args) {
        int[] arr = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
        int target = 33;

        int result = shiftedBinarySearch(arr, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int shiftedBinarySearch(int[] arr, int target) {
        // [45, 61, 71, 72, 73, 0, 1, 21, 33, 37]
        //   0   1   2   3   4  5  6   7   8   9
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (arr[mid] > target && arr[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target && arr[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}
