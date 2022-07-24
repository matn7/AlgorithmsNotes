package whiteboard;

public class SubarraySort {

    public static void main(String[] args) {
//        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] array = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

        subarraySort(array);
    }

    // O(n) time | O(1) space
    // #2: 02/07/2022
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for (int idx = 0; idx < array.length; idx++) {
            int currVal = array[idx];
            if (!isInOrder(currVal, array, idx)) {
                minOutOfOrder = Math.min(minOutOfOrder, currVal);
                maxOutOfOrder = Math.max(maxOutOfOrder, currVal);
            }
        }

        if (minOutOfOrder == Integer.MAX_VALUE && maxOutOfOrder == Integer.MIN_VALUE) {
            return new int[] {-1, -1};
        }

        int leftIdx = 0;
        while (array[leftIdx] <= minOutOfOrder) {
            leftIdx++;
        }

        int rightIdx = array.length - 1;
        while (array[rightIdx] >= maxOutOfOrder) {
            rightIdx--;
        }

        return new int[] {leftIdx, rightIdx};
    }

    private static boolean isInOrder(int currVal, int[] array, int idx) {
        if (idx == 0) {
            return currVal <= array[idx + 1];
        }
        if (idx == array.length - 1) {
            return currVal >= array[idx - 1];
        }
        if (currVal >= array[idx - 1] && currVal <= array[idx + 1]) {
            return true;
        }
        return false;
    }

}
