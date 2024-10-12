package september_2023;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] array = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        kadanesAlgorithm(array);
    }

    // O(n) time | O(1) space
    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.
        //      [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
        // here =                                      16
        // maxSoFar = 19
        int maxSoFar = array[0];
        int maxHere = array[0];
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            maxHere = Math.max(maxHere + num, num);
            maxSoFar = Math.max(maxHere, maxSoFar);
        }
        return maxSoFar;
    }

}
