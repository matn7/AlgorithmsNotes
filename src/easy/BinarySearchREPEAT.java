package easy;

public class BinarySearchREPEAT {

    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        binarySearch(array, 33);
    }

//    public static int binarySearch(int[] array, int target) {
//        // O(log(n)) time | O(1) space
//        return binarySearchHelper(array, target, 0, array.length - 1);
//    }
//
//    //                     *
//    //      0  1   2   3   4   5   6   7   8   9
//    // rec([0, 1, 21, 33, 45, 45, 61, 71, 72, 73], 33, 0, 9)
//    //             l   r
//    private static int binarySearchHelper(int[] array, int target, int left, int right) {
//        while (left <= right) {
//            int middle = (left + right) / 2; // (2+3)/2 = 2
//            int potentialMatch = array[middle]; // 21
//            if (potentialMatch == target) { // 21 == 33
//                return middle;
//            } else if (potentialMatch > target) { // 21 > 33
//                right = middle - 1; // 3
//            } else {
//                left = middle + 1; // 3
//            }
//        }
//        return -1;
//    }

    // OK - repeated 02/03/2022
    // O(log(n)) time | O(log(n)) space
    public static int binarySearch(int[] array, int target) {
        return binarySearchHelper(array, target, 0, array.length - 1);
    }

    // rec([0, 1, 21, 33, 45, 45, 61, 71, 72, 73], 33, 3, 3)
    // rec([0, 1, 21, 33, 45, 45, 61, 71, 72, 73], 33, 2, 3)
    // rec([0, 1, 21, 33, 45, 45, 61, 71, 72, 73], 33, 0, 3)
    // rec([0, 1, 21, 33, 45, 45, 61, 71, 72, 73], 33, 0, 9)
    //      0  1   2   3   4   5   6   7   8   9
    //                     *
    private static int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2; // (3 + 3)/2 = 3
        int potentialMatch = array[middle]; // 33
        if (potentialMatch == target) { // 33 ==  33
            return middle; // 3
        } else if (potentialMatch > target) { // 21 > 33
            // rec([0, 1, 21, 33, 45, 45, 61, 71, 72, 73], 33, 0, 3)
            return binarySearchHelper(array, target, left, middle - 1);
        } else {
            // rec([0, 1, 21, 33, 45, 45, 61, 71, 72, 73], 33, 3, 3)
            return binarySearchHelper(array, target, middle + 1, right);
        }
    }

//    // O(log(n)) time | O(1) space
//    public static int binarySearch(int[] array, int target) {
//        // Write your code here.
//        int left = 0;
//        int right = array.length - 1;
//        while (left < right) {
//            int middle = (left + right) / 2;
//            if (array[middle] == target) {
//                return middle;
//            }
//            if (array[middle] > target) {
//                right = middle - 1;
//            } else {
//                left = middle + 1;
//            }
//        }
//        return -1;
//    }

}
