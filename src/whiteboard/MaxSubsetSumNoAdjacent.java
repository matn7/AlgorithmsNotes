package whiteboard;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {
        int[] array = {75, 105, 120, 75, 90, 135};

        maxSubsetSumNoAdjacent(array);
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array.length < 3) {
            return Math.max(array[0], array[1]);
        }
        int[] sums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sums[i] = array[i];
        }
        sums[2] = Math.max(array[2], array[2] + array[0]);
        for (int i = 3; i < array.length; i++) {
            sums[i] = Math.max(array[i] + sums[i - 3], array[i] + sums[i - 2]);
        }
        int max = -9999;
        for (int element : sums) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

}
