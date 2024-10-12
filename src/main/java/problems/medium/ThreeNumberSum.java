package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        threeNumberSum(array, targetSum);
    }

    // O(n^2) time | O(n) space
    // OK - repeated 07/02/2022
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        // sort array
        // left right pointer
        List<Integer[]> triplets = new ArrayList<Integer[]>();

        // [12, 3, 1, 2, -6, 5, -8, 6]
        Arrays.sort(array); // O(nlog(n)) time | O(1) space
        //                          lr
        // [-8, -6, 1, 2, 3, 5, 6, 12]
        for (int i = 0; i < array.length - 2; i++) {
            int currentNumber = array[i]; // 1
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = currentNumber + array[left] + array[right]; // 1 + 2 + 12 = -1
                if (currentSum == targetSum) {
                    Integer[] res = new Integer[]{currentNumber, array[left], array[right]};
                    triplets.add(res);
                    left++;
                    right--;
                } else if (currentSum < targetSum) { // 7 < 0
                    // to small
                    left++;
                } else { // currentSum > targetSum
                    // to large
                    right--;
                }
            }
        }
        return triplets; // [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
    }

}
