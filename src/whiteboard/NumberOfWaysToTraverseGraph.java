package whiteboard;

public class NumberOfWaysToTraverseGraph {

    // O(nm) time | O(nm) space
    // #2: 13/07/2022
    // rand: 28/08/2022
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

}

