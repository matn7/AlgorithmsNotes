package star;

public class ShiftedBinarySearch {

    public static void main(String[] args) {
//        int[] array = {45, 61, 71, 72, 73, 0, 1, 32, 33, 37};
        int[] array = {-1000, 0, 1, 2};

        int result = shiftedBinarySearch(array, 1);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int shiftedBinarySearch(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;

        // 45 61 71 72 73 0 1 21 33 37
        //  s          m             e

        while (start < end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                if (array[start] < array[mid] && array[start] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (array[end] > array[mid] && array[end] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    // O(log(n)) time | O(log(n)) space
    public static int shiftedBinarySearchRec(int[] array, int target) {
        return shiftedBinarySearchRecHelper(array, target, 0, array.length - 1);
    }

    private static int shiftedBinarySearchRecHelper(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            if (array[start] < array[mid] && array[start] > target) {
                return shiftedBinarySearchRecHelper(array, target, mid + 1, end);
            } else {
                return shiftedBinarySearchRecHelper(array, target, start, mid - 1);
            }
        } else {
            if (array[end] > array[mid] && array[end] < target) {
                return shiftedBinarySearchRecHelper(array, target, start, mid - 1);
            } else {
                return shiftedBinarySearchRecHelper(array, target, mid + 1, end);
            }
        }
    }
}
