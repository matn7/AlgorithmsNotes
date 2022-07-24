package whiteboard;

import java.util.Arrays;

public class ArrayOfProducts {

    // O(n) time | O(n) space
    // #2: 11/07/2022
    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        Arrays.fill(result, 1);
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        int leftRunning = 1;
        for (int i = 0; i < array.length; i++) {
            leftProducts[i] = leftRunning;
            leftRunning *= array[i];
        }

        int rightRunning = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightProducts[i] = rightRunning;
            rightRunning *= array[i];
        }

        for (int i = 0; i < array.length; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }

}
