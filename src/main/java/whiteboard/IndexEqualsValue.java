package whiteboard;

public class IndexEqualsValue {

    // O(log(n)) time | O(1) space
    public int indexEqualsValue(int[] array) {
        // Write your code here.
        int start = 0;
        int end = array.length - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == mid) {
                min = Math.min(mid, min);
                end--;
            } else if (array[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }

    // O(n) time | O(1) space
    public int indexEqualsValue2(int[] array) {
        // Write your code here.
        for (int index = 0; index < array.length; index++) {
            int value = array[index];
            if (index == value) {
                return index;
            }
        }
        return -1;
    }

    // O(log(n)) time | O(log(n)) space
    public int indexEqualsValue3(int[] array) {
        return indexEqualsValueHelper(array, 0, array.length - 1);
    }

    public int indexEqualsValueHelper(int[] array, int leftIndex, int rightIndex) {
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

    // O(log(n)) time | O(1) space
    public int indexEqualsValue4(int[] array) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
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
    
}
