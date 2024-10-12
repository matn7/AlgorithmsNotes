package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumPassesOfMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, -1, -3,  2,  0},
                {1, -2, -5, -1, -3},
                {3,  0,  0, -4, -1}
        };

        MinimumPassesOfMatrix minimumPassesOfMatrix = new MinimumPassesOfMatrix();
        minimumPassesOfMatrix.minimumPassesOfMatrix(matrix);
    }

    // O(w*h) time | O(w*h) space
    // OK - repeated 18/02/2022
    public int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
//        [0, -1, -3,  2,  0],
//        [1, -2, -5, -1, -3],
//        [3,  0,  0, -4, -1]
        int passes = convertNegative(matrix);

        if (!containsNegative(matrix)) {
            return passes - 1; // 4 - 1 = 3
        }
        return -1;
    }

    private int convertNegative(int[][] matrix) {
//        [0, -1, -3,  2,  0],
//        [1, -2, -5, -1, -3],
//        [3,  0,  0, -4, -1]
        Queue<NodeInfo> queue = getAllPositivePositions(matrix);
        int passes = 0;

        // queue
        // ------------------------------
        //
        // ------------------------------
        while (!queue.isEmpty()) {
            int currentSize = queue.size(); // 1

            while (currentSize > 0) {
                NodeInfo current = queue.poll(); // (2,4)
                int currentRow = current.row; // 2
                int currentCol = current.col; // 4

                List<NodeInfo> adjacentPositions = getAdjacentPositions(currentRow, currentCol, matrix);
                //     *
                // [(1,4),(2.3)]
                for (NodeInfo position : adjacentPositions) {
                    int row = position.row; // 1
                    int col = position.col; // 2

                    int value = matrix[row][col]; // -1
                    if (value < 0) {
                        matrix[row][col] = -1 * value;
                        queue.add(new NodeInfo(row, col)); // (2,4)
                    }
                }
                currentSize--; // 0
            }
            passes++; // 4
        }
        return passes;
    }
    //                         c
    //         0   1   2   3   4
    //        ---------------------+
    //        [0,  1,  3,  2,  0], |
    //        [1,  2,  5,  1,  3], |
    //        [3,  0,  0,  4,  1]  | row

    // rec(2, 4, [][])
    // rec(0, 1, [][])
    // rec(1, 4, [][])
    // rec(1, 2, [][])
    // rec(2, 3, [][])
    // rec(1, 1, [][])
    // rec(0, 2, [][])
    // rec(1, 3, [][])
    // rec(2, 0, [][])
    // rec(1, 0, [][])
    // rec(0, 3, [][])
    private List<NodeInfo> getAdjacentPositions(int row, int col, int[][] matrix) {
        List<NodeInfo> adjacentPositions = new ArrayList<>(); //

        if (row > 0) {
            adjacentPositions.add(new NodeInfo(row - 1, col));
        }
        if (row < matrix.length - 1) {
            adjacentPositions.add(new NodeInfo(row + 1, col));
        }
        if (col > 0) {
            adjacentPositions.add(new NodeInfo(row, col - 1));
        }
        if (col < matrix[0].length - 1) {
            adjacentPositions.add(new NodeInfo(row, col + 1));
        }

        return adjacentPositions; //
    }
    //                         c
    //         0   1   2   3   4
    //        ---------------------+
    //        [0, -1, -3,  2,  0], |
    //        [1, -2, -5, -1, -3], |
    //        [3,  0,  0, -4, -1]  |    row
    private Queue<NodeInfo> getAllPositivePositions(int[][] matrix) {
        Queue<NodeInfo> positivePositions = new LinkedList<>();

        // ------------------------------
        //  (0, 3) (1, 0) (2,0)
        // ------------------------------

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int value = matrix[row][col];
                if (value > 0) {
                    positivePositions.add(new NodeInfo(row, col));
                }
            }
        }
        return positivePositions;
    }

    private boolean containsNegative(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < 0) {
                    return true;
                }
            }
        }
        return false;
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
