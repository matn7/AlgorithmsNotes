package hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class QuickSelectREPEAT {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 7, 6, 3};

        quickselect(array, 3);
    }

    // O(n) time | O(k) space
    // OK - repeated 02/02/2022
    public static int quickselect(int[] array, int k) {
        // Write your code here.
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        //          5
        //        2   3
        for (int i = 0; i < array.length; i++) {
            if (heap.size() < k) {
                heap.add(array[i]);
            } else {
                int topElement = heap.peek(); // 6
                if (topElement > array[i]) { // 6 > 3
                    heap.poll();
                    heap.add(array[i]);
                }
            }
        }

        return heap.peek();
    }

//    // Best: O(n) time | O(1) space
//    // Average: O(n) time | O(1) space
//    // Worst: O(n^2) time | O(1) space
//    public static int quickselect(int[] array, int k) {
//        // Write your code here.
//        int position = k - 1; // 2
//        return quickSelectHelper(array, 0, array.length - 1, position);
//    }
//
//    private static int quickSelectHelper(int[] array, int startIdx, int endIdx, int position) {
//        while (true) {
//            if (startIdx > endIdx) {
//                throw new RuntimeException("Your algorithm should never arrive here!");
//            }
//            int pivotIdx = startIdx; // 0
//            int leftIdx = startIdx + 1; // 1
//            int rightIdx = endIdx; // 3
//            //[ 8, 5, 2, 9, 7, 6, 3]
//            //[ 8, 5, 2, 3, 7, 6, 9]
//            //[ 6, 5, 2, 3, 7, 8, 9]
//            //  p              r  l
//            // --------------------
//            //[ 6, 5, 2, 3, 7, 8, 9]
//            //[ 3, 5, 2, 6, 7, 8, 9]
//            //  p        r  l
//            // --------------------
//            //[ 3, 5, 2, 6, 7, 8, 9]
//            //[ 3, 2, 5, 6, 7, 8, 9]
//            //[ 2, 3, 5, 6, 7, 8, 9]
//            //  p  rl
//            while (leftIdx <= rightIdx) {
//                // 3 > 2 && 3 < 2
//                if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
//                    swap(leftIdx, rightIdx, array);
//                }
//                // 3 <= 2
//                if (array[leftIdx] <= array[pivotIdx]) {
//                    leftIdx++;
//                }
//                // 3 >= 2
//                if (array[rightIdx] >= array[pivotIdx]) {
//                    rightIdx--;
//                }
//            }
//            swap(pivotIdx, rightIdx, array);
//            if (rightIdx == position) { // 1 == 2
//                return array[rightIdx];
//            } else if (rightIdx < position) { // 3 < 2
//                startIdx = rightIdx + 1;
//            } else {
//                endIdx = rightIdx - 1;
//            }
//        }
//    }
//
//    private static void swap(int i, int j, int[] array) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }

}
