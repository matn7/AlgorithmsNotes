package hard;

public class IndexEqualsValue {

    public static void main(String[] args) {
        IndexEqualsValue indexEqualsValueREPEAT = new IndexEqualsValue();
//        int[] array = {-5, -3, 0, 3, 4, 5, 9};
        int[] array = {1, 2, 3, 3, 99, 100, 102, 189, 286};
        System.out.println(indexEqualsValueREPEAT.indexEqualsValue(array));
    }

    // O(log(n)) time | O(1) space
    public int indexEqualsValue(int[] array) {
        // Write your code here.
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            int middleValue = array[middleIndex];

            if (middleValue < middleIndex) {
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


    // O(log(n)) time | O(log(n)) space
    public int indexEqualsValueRecursive(int[] array) {
        // Write your code here.
        return indexEqualsValueHelper(array, 0, array.length - 1);
    }

    private int indexEqualsValueHelper(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return -1;
        }

        int middleIndex = (leftIndex + rightIndex) / 2;
        int middleValue = array[middleIndex];

        if (middleValue < middleIndex) {
            return indexEqualsValueHelper(array, middleIndex + 1, rightIndex);
        } else if (middleValue == middleIndex && middleIndex == 0) {
            return middleIndex;
        } else if (middleValue == middleIndex && array[middleIndex - 1] < middleIndex - 1) {
            return middleIndex;
        } else {
            return indexEqualsValueHelper(array, leftIndex, middleIndex - 1);
        }
    }
}
