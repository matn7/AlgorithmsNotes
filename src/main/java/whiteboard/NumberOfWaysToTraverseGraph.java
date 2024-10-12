package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToTraverseGraph {

    public static void main(String[] args) {
        NumberOfWaysToTraverseGraph numberOfWaysToTraverseGraph = new NumberOfWaysToTraverseGraph();
        numberOfWaysToTraverseGraph.numberOfWaysToTraverseGraphPermute(4, 3);
    }

    // O(nm) time | O(nm) space
    public int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        int[][] ways = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col == 0) {
                    ways[row][col] = 1;
                } else if (row == 0) {
                    ways[row][col] = 1;
                } else {
                    ways[row][col] = ways[row - 1][col] + ways[row][col - 1];
                }
            }
        }
        return ways[height - 1][width - 1];
    }

    // O(n + m) time | O(1) space
    public int numberOfWaysToTraverseGraphEquation(int width, int height) {
        int xDistanceToCorner = width - 1;
        int yDistanceToCorner = height - 1;

        int numerator = factorial(xDistanceToCorner + yDistanceToCorner);
        int denominator = factorial(xDistanceToCorner) * factorial(yDistanceToCorner);
        return numerator / denominator;
    }

    private int factorial(int num) {
        int result = 1;
        for (int n = 2; n < num + 1; n++) {
            result *= n;
        }
        return result;
    }

    // O(2^(n+m)) time | O(n + m) space
    public int numberOfWaysToTraverseGraphNaive(int width, int height) {
        if (width == 1 || height == 1) {
            return 1;
        }

        return numberOfWaysToTraverseGraphNaive(width - 1, height)
             + numberOfWaysToTraverseGraphNaive(width, height - 1);
    }

    // Does not work
    // O(n * n!) time | O(n * n!) space
    public int numberOfWaysToTraverseGraphPermute(int width, int height) {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < width - 1; i++) {
            input.add("Right");
        }
        for (int i = 0; i < height - 1; i++) {
            input.add("Down");
        }
        List<List<String>> permutations = new ArrayList<>();

        permutationsHelper(input, new ArrayList<>(), permutations);

        return permutations.size();
    }

    private void permutationsHelper(List<String> input, List<String> curr, List<List<String>> permutations) {
        if (input.isEmpty()) {
            permutations.add(curr);
        } else {
            for (int i = 0; i < input.size(); i++) {
                List<String> newInput = new ArrayList<>(input);
                String inputElem = newInput.remove(i);
                List<String> newCurr = new ArrayList<>(curr);
                newCurr.add(inputElem);
                permutationsHelper(newInput, newCurr, permutations);
            }
        }
    }

}

