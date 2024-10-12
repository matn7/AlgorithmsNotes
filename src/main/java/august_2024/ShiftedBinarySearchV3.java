package august_2024;

public class ShiftedBinarySearchV3 {

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

        //   s               m                   e
        // [45, 61, 71, 72, 73,  0,  1, 21, 33, 37]
        //   0   1   2   3   4   5   6   7   8   9

        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[start] <= array[mid]) {
                // left sorted
                if (array[mid] > target && array[start] <= target) {
                    end = mid - 1; // regular binary search
                } else {
                    start = mid + 1;
                }
            } else {
                if (array[mid] < target && array[end] >= target) {
                    start = mid + 1; // regular binary search
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

}
