package medium;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {

        int[] array = {7, 10, 12, 7, 9, 14};

//        int result = maxSubsetSumNoAdjacent(array);
        int result = maxSubsetSumNoAdjacentBetter(array);
        System.out.println(result);
    }

    // O(N) time | O(N) space
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return -1;
        }
        if (array.length == 1) {
            return array[0];
        }
        int[] maxSums = new int[array.length];
        maxSums[0] = array[0];
        maxSums[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            maxSums[i] = Math.max(maxSums[i-1], maxSums[i-2] + array[i]);
        }

        return maxSums[maxSums.length - 1];
    }

    // O(N) time | O(1) space
    public static int maxSubsetSumNoAdjacentBetter(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }

        int current = 0;
        int first = 0;
        int second = 0;

        for (int i = 0; i < array.length; i++) {
            current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }

        return current;
    }

}
