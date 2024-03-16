package october_2023;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {
        int[] arr = {7, 10, 12, 7, 9, 14};

        maxSubsetNoAdjacent(arr);
    }

    // O(n) time | O(n) space
    public static int maxSubsetNoAdjacent(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int[] sums = new int[arr.length];
        sums[0] = arr[0];
        sums[1] = Math.max(arr[0], arr[1]);

        // [7, 10, 12, 7, 9, 14]
        // [7, 10, 12, 7, 9, 14]
        for (int i = 2; i < arr.length; i++) {
            sums[i] = Math.max(sums[i - 1], arr[i] + sums[i - 2]);
        }

        return sums[sums.length - 1];
    }

}
