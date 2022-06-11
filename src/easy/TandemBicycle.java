package easy;

import java.util.Arrays;

public class TandemBicycle {

    public static void main(String[] args) {
        int[] redShirtSpeeds = {5, 5, 3, 9, 2};
        int[] blueShirtSpeed = {3, 6, 7, 2, 1};

        TandemBicycle tandemBicycle = new TandemBicycle();
        int result = tandemBicycle.tandemBicycle(redShirtSpeeds, blueShirtSpeed, false);
        System.out.println(result);
    }

    // OK - repeated 04/03/2022
    // rec([5, 5, 3, 9, 2], [3, 6, 7, 2, 1], true)
    // O(nlog(n)) time | O(n) space
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        Arrays.sort(redShirtSpeeds);  // [2, 3, 5, 5, 9]
        Arrays.sort(blueShirtSpeeds); // [1, 2, 3, 6, 7]

        if (!fastest) {
            // rec([2, 3, 5, 5, 9])
            reverseArrayInPlace(redShirtSpeeds);
        }

        //                     i
        // red  = [2, 3, 5, 5, 9]
        // blue = [1, 2, 3, 6, 7]
        int totalSpeed = 0;
        for (int idx = 0; idx < redShirtSpeeds.length; idx++) {
            int rider1 = redShirtSpeeds[idx]; // 9
            int rider2 = blueShirtSpeeds[blueShirtSpeeds.length - idx - 1]; // 1
            totalSpeed += Math.max(rider1, rider2); // 23 + 9 = 32
        }

        return totalSpeed; // 32
    }

    // rec([2, 3, 5, 5, 9])
    private void reverseArrayInPlace(int[] array) {
        //        se
        // [9, 5, 5, 3, 2]
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start]; // 3
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

//    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
//        // Write your code here.
//        Arrays.sort(redShirtSpeeds);
//        Arrays.sort(blueShirtSpeeds);
//        int[][] pairs = new int[redShirtSpeeds.length][2];
//
//        if (fastest) {
//            int index = 0;
//            int counter = 0;
//            int forwardCounter = redShirtSpeeds.length - 1;
//            for (int i = redShirtSpeeds.length - 1; i >= 0; i -= 2) {
//                pairs[index][0] = redShirtSpeeds[forwardCounter];
//                pairs[index][1] = blueShirtSpeeds[counter];
//
//                counter++;
//                forwardCounter--;
//                index++;
//            }
//
//            counter = 0;
//            forwardCounter = blueShirtSpeeds.length - 1;
//            for (int i = blueShirtSpeeds.length - 1; i > 0; i -= 2) {
//                pairs[index][0] = blueShirtSpeeds[forwardCounter];
//                pairs[index][1] = redShirtSpeeds[counter];
//                counter++;
//                forwardCounter--;
//                index++;
//            }
//
//            int sum = 0;
//            for (int i = 0; i < pairs.length; i++) {
//                if (pairs[i][0] > pairs[i][1]) {
//                    sum += pairs[i][0];
//                } else {
//                    sum += pairs[i][1];
//                }
//            }
//            return sum;
//        } else {
//            int index = 0;
//            int counter = 0;
//            for (int i = 0; i < redShirtSpeeds.length; i++) {
//                pairs[index][0] = redShirtSpeeds[counter];
//                pairs[index][1] = blueShirtSpeeds[counter];
//
//                counter++;
//                index++;
//            }
//            int sum = 0;
//            for (int i = 0; i < pairs.length; i++) {
//                if (pairs[i][0] > pairs[i][1]) {
//                    sum += pairs[i][0];
//                } else {
//                    sum += pairs[i][1];
//                }
//            }
//            return sum;
//        }
//    }
}
