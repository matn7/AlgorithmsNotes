package whiteboard;

public class MaxSubsetSumNoAdjacent2 {
    // O(n) time | O(n) space
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int[] sums = new int[array.length];
        sums[0] = array[0];
        sums[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            sums[i] = Math.max(sums[i-1], array[i] + sums[i - 2]);
        }

        return sums[array.length - 1];
    }
}
