package problems.easy;

import java.util.Arrays;

public class TandemBicycle {

    public static void main(String[] args) {
        int[] redShirtSpeeds = {5, 5, 3, 9, 2};
        int[] blueShirtSpeed = {3, 6, 7, 2, 1};

        TandemBicycle tandemBicycle = new TandemBicycle();
        int result = tandemBicycle.tandemBicycle(redShirtSpeeds, blueShirtSpeed, false);
        System.out.println(result);
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
