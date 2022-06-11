package veryhard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfBinaryTreeTopologies {

    public static void main(String[] args) {
        numberOfBinaryTreeTopologies(3);
    }

    // O(n^2) time | O(n) space
    public static int numberOfBinaryTreeTopologies(int n) {
        // Write your code here.
        List<Integer> cache = new ArrayList<>();
        cache.add(1);

        for (int m = 1; m < n + 1; m++) {
            int numberOfTrees = 0;
            for (int leftTreeSizes = 0; leftTreeSizes < m; leftTreeSizes++) {
                int rightTreeSize = m - 1 - leftTreeSizes;
                int numberOfLestTrees = cache.get(leftTreeSizes);
                int numberOfRightTree = cache.get(rightTreeSize);
                numberOfTrees += numberOfLestTrees * numberOfRightTree;
            }
            cache.add(numberOfTrees);
        }
        return cache.get(n);
    }

//    // O(n^2) time | O(n) space
//    public static int numberOfBinaryTreeTopologies(int n) {
//        // Write your code here.
//        Map<Integer, Integer> cache = new HashMap<>();
//        cache.put(0, 1);
//        return numberOfBinaryTreeTopologiesHelper(n, cache);
//    }
//
//    public static int numberOfBinaryTreeTopologiesHelper(int n, Map<Integer, Integer> cache) {
//        // Write your code here.
//        if (cache.containsKey(n)) {
//            return cache.get(n);
//        }
//        int numberOfTrees = 0;
//        for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
//            int rightTreeSize = n - 1 - leftTreeSize;
//            int numberOfLeftTrees = numberOfBinaryTreeTopologiesHelper(leftTreeSize, cache);
//            int numberOfRightTrees = numberOfBinaryTreeTopologiesHelper(rightTreeSize, cache);
//            numberOfTrees += numberOfLeftTrees * numberOfRightTrees;
//        }
//        cache.put(n, numberOfTrees);
//        return numberOfTrees;
//    }

//    // Upper Bound: O((n*(2n)!/(n!(n+1)!))) time | O(n) space
//    public static int numberOfBinaryTreeTopologies(int n) {
//        // Write your code here.
//        if (n == 0) {
//            return 1;
//        }
//        int numberOfTrees = 0;
//        for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
//            int rightTreeSize = n - 1 - leftTreeSize;
//            int numberOfLeftTrees = numberOfBinaryTreeTopologies(leftTreeSize);
//            int numberOfRightTrees = numberOfBinaryTreeTopologies(rightTreeSize);
//            numberOfTrees += numberOfLeftTrees * numberOfRightTrees;
//        }
//        return numberOfTrees;
//    }

}
