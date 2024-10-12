package problems.veryhard;

import java.util.ArrayList;
import java.util.List;

public class NumberOfBinaryTreeTopologies {

    public static void main(String[] args) {
        int result = numberOfBinaryTreeTopologies(3);
        System.out.println(result);
    }

    // OK - repeated 20/02/2022
    // O(n^2) time | O(n) space
    public static int numberOfBinaryTreeTopologies(int n) {
        List<Integer> cache = new ArrayList<>();
        cache.add(1);
        for (int m = 1; m < n + 1; m++) {
            int numberOfTrees = 0;
            for (int leftTreeSize = 0; leftTreeSize < m; leftTreeSize++) { // 2
                int rightTreeSize = m - 1 - leftTreeSize; // 3 - 1 - 2 = 0
                int numberOfLeftTrees = cache.get(leftTreeSize); // 2
                int numberOfRightTrees = cache.get(rightTreeSize); // 1
                numberOfTrees += numberOfLeftTrees * numberOfRightTrees; // 3 + (2*1) = 5
            }
            cache.add(numberOfTrees);
        }
        return cache.get(n);
    }

    // O(n^2) time | O(n) space
//    public static int numberOfBinaryTreeTopologies(int n) {
//        Map<Integer, Integer> cache = new HashMap<>();
//        cache.put(0, 1);
//        // cache = {0:1}
//        int result = numberOfBinaryTreeTopologiesHelper(n, cache);
//        return result;
//    }

//    public static int numberOfBinaryTreeTopologiesHelper(int n, Map<Integer, Integer> cache) {
//        if (cache.containsKey(n)) {
//            return cache.get(n);
//        }
//        // cache = {0:1,1:1}
//        int numberOfTrees = 0;
//        for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
//            int rightTreeSize = n - 1 - leftTreeSize; // 1 root node
//            System.out.println(n + ":" + leftTreeSize + ":" + rightTreeSize + ":" + numberOfTrees);
//            int numberOfLeftTrees = numberOfBinaryTreeTopologiesHelper(leftTreeSize, cache); // 1
//            int numberOfRightTrees = numberOfBinaryTreeTopologiesHelper(rightTreeSize, cache); // 1
//            numberOfTrees += numberOfLeftTrees * numberOfRightTrees; // 2
//        }
//        cache.put(n, numberOfTrees);
//        return numberOfTrees;
//    }

//    // Upper Bound: O((n*(2n)!/(n!(n+1)!))) time | O(n) space
//    public static int numberOfBinaryTreeTopologies(int n) {
//        if (n == 0) {
//            return 1;
//        }
//        int numberOfTrees = 0;
//        for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
//            int rightTreeSize = n - 1 - leftTreeSize; // 1 root node
//            int numberOfLeftTrees = numberOfBinaryTreeTopologies(leftTreeSize);
//            int numberOfRightTrees = numberOfBinaryTreeTopologies(rightTreeSize);
//            numberOfTrees += numberOfLeftTrees * numberOfRightTrees;
//        }
//        return numberOfTrees;
//    }

}
