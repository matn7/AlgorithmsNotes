package medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysToTraverseGraph {

    public static void main(String[] args) {

        NumberOfWaysToTraverseGraph numberOfWaysToTraverseGraph = new NumberOfWaysToTraverseGraph();
        int result = numberOfWaysToTraverseGraph.numberOfWaysToTraverseGraphMath(3, 4);


        System.out.println(numberOfWaysToTraverseGraph.factorial(4));

        int fact = numberOfWaysToTraverseGraph.fact(4);
        System.out.println(fact);

        System.out.println(result);

    }

    // O(2^(n+m)) time | O(nm) space (call stack)
    public int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        if (width == 1 || height == 1) {
            return 1;
        }

        return numberOfWaysToTraverseGraph(width - 1, height)
                + numberOfWaysToTraverseGraph(width, height - 1);
    }

    // (nm) time | O(nm) space
    public int numberOfWaysToTraverseGraphDP(int width, int height) {
        // Write your code here.
        if (width == 1 || height == 1) {
            return 1;
        }
        int[][] newArray = new int[height][width];
        int sum = 1;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col == 0) {
                    newArray[row][col] = 1;
                } else if (row == 0) {
                    newArray[row][col] = 1;
                } else {
                    newArray[row][col] = newArray[row][col - 1] + newArray[row - 1][col];
                }
            }
        }

        return newArray[height-1][width-1];
    }

    // O(n + m) time | O(1) space
    public int numberOfWaysToTraverseGraphMath(int width, int height) {
        // Write your code here.
        // permutation
        int r = (width - 1);
        int d = (height - 1);
        int result = factorial(r + d) / (factorial(r) * factorial(d));
        return result;
    }

    private int factorial(int number) {
        Map<Integer, Integer> memo = new HashMap<>();

        return helper(number, memo);
    }

    private int helper(int number, Map<Integer, Integer> memo) {

        if (number == 0) {
            return 1;
        }
        if (memo.containsKey(number)) {
            return number;
        }
        memo.put(number,  number * helper(number - 1, memo));
        return memo.get(number);
    }

    private int fact(int number) {
        int result = 1;
        for (int n = 2; n <= number; n++) {
            result *= n;
        }
        return result;
    }

}
