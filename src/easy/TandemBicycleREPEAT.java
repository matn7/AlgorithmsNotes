package easy;

import java.util.Arrays;

public class TandemBicycleREPEAT {

    public static void main(String[] args) {
        int[] redShirtSpeeds = {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = {3, 6, 7, 2, 1};

        TandemBicycleREPEAT tandemBicycleREPEAT = new TandemBicycleREPEAT();
        tandemBicycleREPEAT.tandemBicycle(redShirtSpeeds, blueShirtSpeeds, true);

    }

    // O(nlog(n)) time | O(n) space
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if (!fastest) {
            reverseArrayInPlace(redShirtSpeeds);
        }

        int totalSpeed = 0;
        for (int idx = 0; idx < redShirtSpeeds.length; idx++) {
            int rider1 = redShirtSpeeds[idx];
            int rider2 = blueShirtSpeeds[blueShirtSpeeds.length - idx - 1];
            totalSpeed += Math.max(rider1, rider2);
        }

        return totalSpeed;
    }

    private void reverseArrayInPlace(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
