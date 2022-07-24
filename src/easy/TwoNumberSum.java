package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;

        twoNumberSum(array, targetSum);
    }

    // O(n) time | O(n) space
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Map<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();
        for (int i : array) {
            int currentNum = i;
            int y = targetSum - currentNum;
            if (hashTable.containsKey(y)) {
                int[] result = {y, currentNum};
                return result;
            } else {
                hashTable.put(currentNum, Boolean.TRUE);
            }
        }
        return new int[0];
    }
}
