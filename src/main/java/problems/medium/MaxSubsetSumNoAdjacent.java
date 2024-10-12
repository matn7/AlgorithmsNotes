package problems.medium;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {
        int[] array = {7, 10, 12, 7, 9, 14};
        int result = maxSubsetSumNoAdjacent(array);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        //                            i
        // array = [7, 10, 12, 7, 9, 14]
        int second = array[0]; // 7
        int first = Math.max(array[0], array[1]); // 10
        for (int i = 2; i < array.length; i++) {
            int current = Math.max(first, second + array[i]); // max(28, 19 + 14)
            second = first; // 28
            first = current; // 33
        }
        return first;
    }

    // O(n) time | O(n) space
    public static int maxSubsetSumNoAdjacent2(int[] array) {
        // Write your code here.
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        // array = [7, 10, 12, 7, 9, 14]
        int[] maxSums = new int[array.length];
        // maxSums = [0, 0, 0, 0, 0, 0]
        maxSums[0] = array[0];
        maxSums[1] = Math.max(maxSums[0], array[1]);
        //                               i           i
        // maxSums = [7, 10, 19, 19, 28, 33]
        // array =   [7, 10, 12,  7,  9, 14]
        for (int i = 2; i < array.length; i++) {
            maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + array[i]); // max(28, 19 + 14)
        }
        return maxSums[array.length - 1];
    }

}
