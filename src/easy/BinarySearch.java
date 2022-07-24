package easy;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        binarySearch(array, 33);
    }

    // O(log(n)) time | O(log(n)) space
    public static int binarySearch(int[] array, int target) {
        return binarySearchHelper(array, target, 0, array.length - 1);
    }

    private static int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        int potentialMatch = array[middle];
        if (potentialMatch == target) {
            return middle;
        } else if (potentialMatch > target) {
            return binarySearchHelper(array, target, left, middle - 1);
        } else {
            return binarySearchHelper(array, target, middle + 1, right);
        }
    }

    // O(log(n)) time | O(1) space
    public static int binarySearchIterative(int[] array, int target) {
        // Write your code here.
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == target) {
                return middle;
            }
            if (array[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

}
