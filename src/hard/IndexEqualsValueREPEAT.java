package hard;

public class IndexEqualsValueREPEAT {

    public static void main(String[] args) {
        IndexEqualsValueREPEAT indexEqualsValueREPEAT = new IndexEqualsValueREPEAT();
        int[] array = {-5, -3, 0, 3, 4, 5, 9};
        indexEqualsValueREPEAT.indexEqualsValue(array);
    }

    // O(log(n)) time | O(1) space
    // OK - repeated 04/02/2022
    public int indexEqualsValue(int[] array) {
        // Write your code here.
        //   0   1  2  3  4  5  6
        // [-5, -3, 0, 1, 2, 5, 9]
        //                l     r
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2; // (4 + 6) / 2 = 5
            int middleValue = array[middleIndex]; // 5

            if (middleValue < middleIndex) { // 5 < 5
                leftIndex = middleIndex + 1;
            } else if (middleValue == middleIndex && middleIndex == 0) {
                return middleIndex;
            } else if (middleValue == middleIndex && array[middleIndex - 1] < middleIndex - 1) {
                return middleIndex;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return -1;
    }


//    // O(log(n)) time | O(log(n)) space
//    public int indexEqualsValue(int[] array) {
//        // Write your code here.
//        return indexEqualsValueHelper(array, 0, array.length - 1);
//    }
//
//    private int indexEqualsValueHelper(int[] array, int leftIndex, int rightIndex) {
//        if (leftIndex > rightIndex) {
//            return -1;
//        }
//
//        int middleIndex = (leftIndex + rightIndex) / 2;
//        int middleValue = array[middleIndex];
//
//        if (middleValue < middleIndex) {
//            return indexEqualsValueHelper(array, middleIndex + 1, rightIndex);
//        } else if (middleValue == middleIndex && middleIndex == 0) {
//            return middleIndex;
//        } else if (middleValue == middleIndex && array[middleIndex - 1] < middleIndex - 1) {
//            return middleIndex;
//        } else {
//            return indexEqualsValueHelper(array, leftIndex, middleIndex - 1);
//        }
//    }

//    // O(n) time | O(1) space
//    public int indexEqualsValue(int[] array) {
//        // Write your code here.
//        for (int index = 0; index < array.length; index++) {
//            int value = array[index];
//            if (index == value) {
//                return index;
//            }
//        }
//        return -1;
//    }

}
