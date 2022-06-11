package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;

        twoNumberSum(array, targetSum);
    }

    // OK - repeated 27/02/2022
    // O(n) time | O(n) space
    public static int[] twoNumberSum(int[] array, int targetSum) {
        //                               *
        // array = [3, 5, -4, 8, 11, 1, -1, 6]
        // hashTable = {3: TRUE, 5: TRUE, -4: TRUE, 8: TRUE, 11: TRUE, 1: TRUE}
        Map<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();
        for (int i : array) {
            int currentNum = i; // -1
            int y = targetSum - currentNum; // 10 - (-1) = 11
            if (hashTable.containsKey(y)) {
                int[] result = {y, currentNum}; // {11, -1}
                return result;
            } else {
                hashTable.put(currentNum, Boolean.TRUE);
            }
        }
        return new int[0];
    }
}
