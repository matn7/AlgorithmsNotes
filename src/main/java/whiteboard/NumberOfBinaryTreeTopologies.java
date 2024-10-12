package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBinaryTreeTopologies {
    // O(n^2) time | O(n) space
    public static int numberOfBinaryTreeTopologies(int n) {
        // Write your code here.
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        return numberOfBinaryTreeTopologiesHelper(n, cache);
    }

    private static int numberOfBinaryTreeTopologiesHelper(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int numberOfTrees = 0;
        for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
            int rightTreeSize = n - 1 - leftTreeSize;
            int leftNum = numberOfBinaryTreeTopologiesHelper(leftTreeSize, cache);
            int rightNum = numberOfBinaryTreeTopologiesHelper(rightTreeSize, cache);
            numberOfTrees += leftNum * rightNum;
        }
        cache.put(n, numberOfTrees);
        return cache.get(n);
    }
}
