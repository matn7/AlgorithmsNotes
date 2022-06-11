package hard;

import java.util.Arrays;

public class MinNumberOfJumpsREPEAT {

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        int result = minNumberOfJumps(array);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    // OK - repeated 31/01/2022
    public static int minNumberOfJumps(int[] array) {
        if (array.length == 1) {
            return 0;
        }

        // len(array) = 11
        //                    *
        // [3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3]
        int jumps = 0;
        int maxReach = array[0]; // 3
        int currentMaxReach = maxReach; // 3
        for (int i = 1; i < array.length; i++) {
            if (maxReach > array.length) {
                break;
            }
            maxReach = Math.max(maxReach, i + array[i]); // max(6, 6 + 7) = 13
            if (maxReach != currentMaxReach) { // 13 != 8
                currentMaxReach = maxReach; // 13
                jumps++; // 4
            }
        }
        return jumps;
    }

//    // O(n) time | O(1) space
//    public static int minNumberOfJumps(int[] array) {
//        if (array.length == 1) {
//            return 0;
//        }
//        //          0  1  2  3  4  5  6  7  8  9  10
//        //                                        i
//        // array = [3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3]
//        int jumps = 0;
//        int maxReach = array[0]; // 3
//        int steps = array[0]; // 3
//        for (int i = 1; i < array.length - 1; i++) {
//            maxReach = Math.max(maxReach, i + array[i]); // max(8, 13) = 13
//            steps--; // 3
//            if (steps == 0) {
//                jumps++; // 3
//                steps = maxReach - i; // 13 - 8 = 5
//            }
//        }
//        return jumps + 1; // 4
//    }

//    // O(n^2) time | O(n) space
//    public static int minNumberOfJumps(int[] array) {
//        // Write your code here.
//        //  0  1  2  3  4  5  6  7  8  9  10
//        //                                i
//        // [3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3] array
//        // [0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4] jumps
//        //                             j
//        int[] jumps = new int[array.length];
//        Arrays.fill(jumps, Integer.MAX_VALUE);
//        jumps[0] = 0;
//        for (int i = 1; i < array.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (array[j] + j >= i) {
//                    jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
//                }
//            }
//            System.out.println();
//        }
//        return jumps[array.length - 1];
//    }

}
