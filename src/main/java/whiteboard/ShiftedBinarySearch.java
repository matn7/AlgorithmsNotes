package whiteboard;

public class ShiftedBinarySearch {

    public static void main(String[] args) {
        int[] array = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
//        int[] array = {5, 23, 111, 1};
        int target = 33;

        int result = shiftedBinarySearch(array, target);
        System.out.println();
    }

    // ********
    // * STAR - G *
    // ********

    // O(log(n)) time | O(1) space
    public static int shiftedBinarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[start] <= array[mid]) {
                // left sorted
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
