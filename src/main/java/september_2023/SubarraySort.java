package september_2023;

public class SubarraySort {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        subarraySort(array);
    }

    // O(n) time | O(1) space
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        // [1, 2, 4, 7, 11, 7, 12, 6, 7, 16, 18, 19]
        //               *
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (!isInOrder(array, i)) {
                minOutOfOrder = Math.min(minOutOfOrder, array[i]);
                maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
            }
        }
        if (minOutOfOrder == Integer.MAX_VALUE || maxOutOfOrder == Integer.MIN_VALUE) {
            return new int[] {-1, -1};
        }

        int startIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > minOutOfOrder) {
                startIdx = i;
                break;
            }
        }

        int endIdx = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < maxOutOfOrder) {
                endIdx = i;
                break;
            }
        }

        return new int[] {startIdx, endIdx};
    }

    private static boolean isInOrder(int[] array, int idx) {
        if (idx == 0) {
            return array[idx] <= array[idx + 1];
        } else if (idx == array.length - 1) {
            return array[idx] >= array[idx - 1];
        }
        return array[idx] >= array[idx - 1] && array[idx] <= array[idx + 1];
    }

}
