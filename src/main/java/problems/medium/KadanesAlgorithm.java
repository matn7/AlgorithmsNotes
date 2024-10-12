package problems.medium;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] array = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        int result = kadanesAlgorithm(array);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    // OK - repeated 07/02/2022
    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.
        //                                                           i
        // array = [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
        int maxNumberHere = array[0]; // 3
        int maxSoFar = array[0]; // 3
        for (int i = 1; i < array.length; i++) {
            maxNumberHere = Math.max(maxNumberHere + array[i], array[i]); // max(14 + 4, 4) = 18
            maxSoFar = Math.max(maxSoFar, maxNumberHere); // max(19, 18) = 19
        }
        return maxSoFar;
    }

}
