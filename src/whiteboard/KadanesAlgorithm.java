package whiteboard;

public class KadanesAlgorithm {

    // O(n) time | O(1) space
    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.
        int maxNumHere = array[0];
        int maxSoFar = array[0];
        for (int i = 1; i < array.length; i++) {
            maxNumHere = Math.max(maxNumHere + array[i], array[i]);
            maxSoFar = Math.max(maxSoFar, maxNumHere);
        }
        return maxSoFar;
    }

}
