package whiteboard;

public class BinarySearch  {

    // O(log(n)) time | O(log(n)) space
    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        return binarySearchHelper(array, target, 0, array.length - 1);
    }

    private static int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        int value = array[middle];
        if (value == target) {
            return middle;
        } else if (target < value) {
            return binarySearchHelper(array, target, left, middle - 1);
        } else {
            return binarySearchHelper(array, target, middle + 1, right);
        }
    }

//    // O(log(n)) time | O(1) space
//    public static int binarySearch(int[] array, int target) {
//        // Write your code here.
//        int left = 0;
//        int right = array.length - 1;
//
//        while (left < right) {
//            int middle = (left + right) / 2;
//            int value = array[middle];
//
//            if (value == target) {
//                return middle;
//            } else if (target < value) {
//                right = middle - 1;
//            } else {
//                left = middle + 1;
//            }
//        }
//
//        return -1;
//    }
}

