package whiteboard;

public class SubarraySortRand {

    // O(n) time | O(1) space
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int minInvalid = Integer.MAX_VALUE;
        int maxInvalid = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (!isValidOrder(i, array)) {
                minInvalid = Math.min(minInvalid, array[i]);
                maxInvalid = Math.max(maxInvalid, array[i]);
            }
        }

        if (minInvalid == Integer.MAX_VALUE && maxInvalid == Integer.MIN_VALUE) {
            return new int[] {-1, -1};
        }

        int leftIdx = 0;
        while (array[leftIdx] <= minInvalid) {
            leftIdx++;
        }

        int rightIdx = array.length - 1;
        while (array[rightIdx] >= maxInvalid) {
            rightIdx--;
        }

        return new int[] {leftIdx, rightIdx};
    }

    private static boolean isValidOrder(int i, int[] array) {
        if (i == 0) {
            return array[i] <= array[i + 1];
        } else if (i == array.length - 1) {
            return array[i] >= array[i - 1];
        } else {
            return array[i] >= array[i - 1] && array[i] <= array[i + 1];
        }
    }

}
