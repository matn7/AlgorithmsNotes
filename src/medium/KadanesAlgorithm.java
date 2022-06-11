package medium;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] array = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};

        int result = kadanesAlgorithm(array);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.
        int maxEndingHere = 0;
        int max = -9999;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            maxEndingHere = Math.max(maxEndingHere + num, num);
            if (maxEndingHere > max) {
                max = maxEndingHere;
            }
        }
        return max;
    }

}
