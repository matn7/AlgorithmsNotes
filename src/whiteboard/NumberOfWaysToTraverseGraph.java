package whiteboard;

public class NumberOfWaysToTraverseGraph {

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

}

