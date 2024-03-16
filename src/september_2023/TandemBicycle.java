package september_2023;

import java.util.Arrays;

public class TandemBicycle {

    public static void main(String[] args) {
        int[] redShirtSpeeds = {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = {3, 6, 7, 2, 1};

        TandemBicycle tandemBicycle = new TandemBicycle();
        tandemBicycle.tandemBicycle(redShirtSpeeds, blueShirtSpeeds, false);
    }

    // O(nlog(n)) time | O(1) space
    public int tandemBicycle(
            int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest
    ) {
        // Write your code here.
        // 5, 5, 3, 9, 2  -> 2, 3, 5, 5, 9
        // 3, 6, 7, 2, 1  -> 7, 6, 3, 1, 1
        // fastest
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if (fastest) {
            reverse(blueShirtSpeeds);
        }
        int sum = 0;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }
        return sum;
    }

    private void reverse(int[] array) {
        // 7, 6, 3, 1, 1
        // *           *
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
