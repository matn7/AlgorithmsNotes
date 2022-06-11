package hard;

public class ShiftedBinarySearchREPEAT {


    public static void main(String[] args) {
        int[] array = {45, 61, 71, 72, 73, 0, 1, 21, 33, 37};
//        int[] array = {0, 1, 21, 33, 37, 45, 61, 71, 72, 73};
        int result = shiftedBinarySearch(array, 1); // target 33
        System.out.println(result);
    }

    public static int shiftedBinarySearch(int[] array, int target) {
        return shiftedBinarySearchHelper(array, target, 0, array.length - 1);
    }

    // O(log(n)) time | O(d) space
    // OK - repeated 27/01/2022
    public static int shiftedBinarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        //   0   1   2   3   4  5  6   7   8   9
        // [45, 61, 71, 72, 73, 0, 1, 21, 33, 37]
        int middle = (left + right) / 2; // (8 + 9) = 17 / 2 = 8
        int potentialMatch = array[middle]; // 33
        int leftNum = array[left]; // 33
        int rightNum = array[right]; // 37
        if (potentialMatch == target) { // 33 == 33 -> no
            return middle;
        } else if (leftNum <= potentialMatch) { // 0 <= 21
            // entire left subarray is sorted
            if (target < potentialMatch && target >= leftNum) { // 33 < 21 && 33 >= 0
                // left
                return shiftedBinarySearchHelper(array, target, left, middle - 1);
            } else {
                // right
                // rec(array, 33, 5, 9)
                // rec(array, 33, 8, 9)
                return shiftedBinarySearchHelper(array, target, middle + 1, right);
            }
        } else {
            // entire left unsorted
            if (target > potentialMatch && target <= rightNum) {
                return shiftedBinarySearchHelper(array, target, middle + 1, right);
            } else {
                return shiftedBinarySearchHelper(array, target, left, middle - 1);
            }
        }
    }

    // O(log(n)) time | O(1) space
    public static int shiftedBinarySearchHelper2(int[] array, int target, int left, int right) {
        // Write your code here.
        // target = 33
        //   0   1   2   3   4  5  6   7   8   9
        // [45, 61, 71, 72, 73, 0, 1, 21, 33, 37]
        // left = 0
        // right = 9
        while (left < right) {
            int middle = (left + right) / 2; // (8+9)/2 = 8
            int potentialMatch = array[middle]; // 33
            int leftNum = array[left]; // 33
            int rightNum = array[right]; // 37
            if (potentialMatch == target) {
                return middle;
            } else if (leftNum <= potentialMatch) { // 0 <= 21
                // entire left subarray is sorted
                if (target < potentialMatch && target >= leftNum) { // 33 < 21 && 33 >= 45
                    right = middle - 1; // whether our target is in left subarray
                } else {
                    left = middle + 1;
                }
            } else {
                // entire left unsorted
                if (target > potentialMatch && target <= rightNum) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }

}
















