package october_2023;

public class ShiftedBinarySearch {

    public static void main(String[] args) {
        int[] arr = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
        int target = 33;

        System.out.println(shiftedBinarySearch(arr, target));
    }

    // O(log(n)) time | O(1) space
    public static int shiftedBinarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        //   0   1   2   3   4  5  6   7   8   9
        // [45, 61, 71, 72, 73, 0, 1, 21, 33, 37]
        //                      s      *
        //                                     e

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                if (arr[start] < arr[mid] && arr[start] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[end] > arr[mid] && arr[end] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;

    }

}
