package august_2024;

public class ShiftedBinarySearchV2 {

    public static void main(String[] args) {
        int[] array = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
        int target = 33;

        int result = shiftedBinarySearch(array, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int shiftedBinarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        //   0   1   2   3   4  5  6   7   8   9
        // [45, 61, 71, 72, 73, 0, 1, 21, 33, 37]
        //                      s      m   *   e

        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[start] <= array[mid]) {
                // left sorted
                //   73 > 33 && 33 >= 45
                if (array[mid] > target && target >= array[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (array[mid] < target && target <= array[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}
