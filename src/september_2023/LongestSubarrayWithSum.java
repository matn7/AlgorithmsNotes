package september_2023;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayWithSum {

    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4, 3, 3, 1, 2, 1, 2};
        int[] array = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        int targetSum = 1;

        LongestSubarrayWithSum longestSubarrayWithSum = new LongestSubarrayWithSum();
        int[] ints = longestSubarrayWithSum.longestSubarrayWithSum(array, targetSum);
        System.out.println();
    }

    // O(n) time | O(1) space
    public int[] longestSubarrayWithSum(int[] array, int targetSum) {
        // Write your code here.
        List<Integer> indices = new ArrayList<>();

        int currentSubarraySum = 0;
        int startingIndex = 0;
        int endingIndex = 0;

        while (endingIndex < array.length) {
            currentSubarraySum += array[endingIndex];

            while (startingIndex < endingIndex && currentSubarraySum > targetSum) {
                currentSubarraySum -= array[startingIndex];
                startingIndex++;
            }
            if (currentSubarraySum == targetSum) {
                if (indices.size() == 0) {
                    indices.add(0, startingIndex);
                    indices.add(1, endingIndex);
                } else if (endingIndex - startingIndex > indices.get(1) - indices.get(0)) {
                    indices.set(0, startingIndex);
                    indices.set(1, endingIndex);
                }
            }
            endingIndex++;
        }
        if (indices.size() == 0) {
            return new int[] {};
        }
        return new int[] {indices.get(0), indices.get(1)};
    }

}
