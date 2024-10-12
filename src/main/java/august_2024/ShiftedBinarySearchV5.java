package august_2024;

public class ShiftedBinarySearchV5 {

    public static void main(String[] args) {
        int[] array = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37, 39, 40, 41};
        int target = 0;

        int result = shiftedBinarySearch(array, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int shiftedBinarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[start] <= array[mid]) {
                if (array[start] <= target && array[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (array[end] >= target && array[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


}
