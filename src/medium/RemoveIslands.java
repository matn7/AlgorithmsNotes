package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveIslands {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };

        RemoveIslands removeIslands = new RemoveIslands();
        removeIslands.removeIslands(matrix);
    }

    // O(w*h) time | O(w*h) space
    // OK - repeated 17/02/2022
    public int[][] removeIslands(int[][] matrix) {
        // Write your code here.
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) { // 1
                boolean rowIsBorder = row == 0 || row == matrix.length - 1; // true
                boolean colIsBorder = col == 0 || col == matrix[row].length - 1; // true
                boolean isBorder = rowIsBorder || colIsBorder; // true
                if (!isBorder) {
                    continue;
                }

                if (matrix[row][col] != 1) {
                    continue;
                }

                changeOnesConnectedToBorderToTwos(matrix, row, col);
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int color = matrix[row][col];
                if (color == 1) {
                    matrix[row][col] = 0;
                } else if (color == 2) {
                    matrix[row][col] = 1;
                }
            }
        }

        return matrix;
    }

    private void changeOnesConnectedToBorderToTwos(int[][] matrix, int startRow, int startCol) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(startRow, startCol));
        // ---------------
        // | (5,5)
        // ---------------

        while (!stack.isEmpty()) {
            NodeInfo currentPosition = stack.pop(); // (5,5)

            matrix[currentPosition.row][currentPosition.col] = 2;

            List<NodeInfo> neighbors = getNeighbors(matrix, currentPosition.row, currentPosition.col);

            // [(4,5), (5,4)]
            for (NodeInfo neighbor : neighbors) {
                int row = neighbor.row;
                int col = neighbor.col;

                if (matrix[row][col] != 1) {
                    continue;
                }

                stack.push(neighbor);
            }
        }
    }

    private List<NodeInfo> getNeighbors(int[][] matrix, int row, int col) { // (3,1)
        List<NodeInfo> neighbors = new ArrayList<>();

        int numRows = matrix.length;
        int numCols = matrix[row].length;

        if (row - 1 >= 0) { // up
            neighbors.add(new NodeInfo(row - 1, col));
        }
        if (row + 1 < numRows) { // down
            neighbors.add(new NodeInfo(row + 1, col));
        }
        if (col - 1 >= 0) { // left
            neighbors.add(new NodeInfo(row, col - 1));
        }
        if (col + 1 < numCols) { // right
            neighbors.add(new NodeInfo(row, col + 1));
        }
        return neighbors; //
    }

    static class NodeInfo {
        int row;
        int col;

        public NodeInfo(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
