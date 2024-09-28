package july_2024;

import java.util.ArrayList;
import java.util.List;

public class LongestSubArrayWithSum {

    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4, 3, 3, 1, 2, 1, 2};
//        int targetSum = 10;

        int[] array = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        int targetSum = 1;

        int[] result = longestSubArray(array, targetSum);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int[] longestSubArray(int[] array, int targetSum) {
        List<Integer> indicies = new ArrayList<>();
        int startIdx = 0;
        int endIdx = 0;
        int currentSum = 0;
        while (endIdx < array.length) {
            currentSum += array[endIdx];
            while (startIdx < endIdx && currentSum > targetSum) {
                currentSum -= array[startIdx];
                startIdx++;
            }
            if (currentSum == targetSum) {
                if (indicies.size() == 0) {
                    indicies.add(0, startIdx);
                    indicies.add(1, endIdx);
                } else if (endIdx - startIdx > indicies.get(1) - indicies.get(0)) {
                    indicies.set(0, startIdx);
                    indicies.set(1, endIdx);
                }
            }
            endIdx++;
        }
        if (indicies.isEmpty()) {
            return new int[] {};
        }
        return new int[] {indicies.get(0), indicies.get(1)};
    }

}
