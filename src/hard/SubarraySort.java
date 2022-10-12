package hard;

public class SubarraySort {

    public static void main(String[] args) {
        int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};

        subarraySort(array);
    }

    // O(n) time | O(1) space
    // OK - repeated 28/01/2022
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        //  0  1  2  3   4   5  6   7  8  9  10  11  12
        // [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]
        // get unsorted smallest and largest numbers
        for (int i = 0; i < array.length; i++) { // i = 12
            int num = array[i]; // 19
            if (isOutOfOrder(i, num, array)) {
                minOutOfOrder = Math.min(minOutOfOrder, num); // 6
                maxOutOfOrder = Math.max(maxOutOfOrder, num); // 12
            }
        }
        if (minOutOfOrder == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        }
        int subarrayLeftIdx = 0;
        while (minOutOfOrder >= array[subarrayLeftIdx]) {
            subarrayLeftIdx++; // 3
        }
        int subarrayRightIdx = array.length - 1;
        while (maxOutOfOrder <= array[subarrayRightIdx]) {
            subarrayRightIdx--; // 9
        }
        return new int[] {subarrayLeftIdx, subarrayRightIdx}; // [3, 9]
    }
    //  0  1  2  3   4   5  6   7  8  9  10  11  12
    // [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19*]
    private static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0) {
            return num > array[i + 1];
        }
        if (i == array.length - 1) {
            return num < array[i - 1]; // 19 < 18
        }
        return num > array[i + 1] || num < array[i - 1]; // 18 > 19 || 18 < 16
    }

}
