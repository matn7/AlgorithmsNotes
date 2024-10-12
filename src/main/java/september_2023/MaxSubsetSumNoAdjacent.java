package september_2023;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {
        int[] array = {75, 105, 120, 75, 90, 135};

        maxSubsetSumNoAdjacent(array);
    }

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
        for (int i = 0; i < array.length; i++) {
            sums[i] = array[i];
        }

        // sums = [75, 105, 120, 75, 90, 135]
        //
        sums[1] = Math.max(sums[0], sums[1]);
        for (int i = 2; i < array.length; i++) {
            sums[i] = Math.max(sums[i - 1], sums[i] + sums[i - 2]);
        }

        return sums[sums.length - 1];
    }

}
