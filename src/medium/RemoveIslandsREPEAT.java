package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveIslandsREPEAT {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };

        RemoveIslandsREPEAT removeIslands = new RemoveIslandsREPEAT();
        removeIslands.removeIslands(matrix);
    }
//     *
//     0  1  2  3  4  5
// -----------------------+
//    {1, 0, 0, 0, 0, 0}, | 0   row
//    {0, 1, 0, 1, 1, 1}, | 1
//    {0, 0, 1, 0, 1, 0}, | 2
//    {1, 1, 0, 0, 1, 0}, | 3
//    {1, 0, 1, 1, 0, 0}, | 4
//    {1, 0, 0, 0, 0, 1}  | 5

//                    *
//     0  1  2  3  4  5
// -----------------------+
//    {1, 0, 0, 0, 0, 0}, | 0
//    {0, 0, 0, 1, 1, 1}, | 1
//    {0, 0, 0, 0, 1, 0}, | 2
//    {1, 1, 0, 0, 1, 0}, | 3
//    {1, 0, 0, 0, 0, 0}, | 4
//    {1, 0, 0, 0, 0, 1}  | 5   row

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

//    // O(w*h) time | O(w*h) space
//    public int[][] removeIslands(int[][] matrix) {
//        // Write your code here.
//        boolean[][] onesConnectedToBorder = new boolean[matrix.length][matrix[0].length];
//
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                boolean rowIsBorder = row == 0 || row == matrix.length - 1;
//                boolean colIsBorder = col == 0 || col == matrix[row].length - 1;
//                boolean isBorder = rowIsBorder || colIsBorder;
//                if (!isBorder) {
//                    continue;
//                }
//
//                if (matrix[row][col] != 1) {
//                    continue;
//                }
//
//                findOnesConnectedToBorder(matrix, row, col, onesConnectedToBorder);
//            }
//        }
//
//        for (int row = 1; row < matrix.length - 1; row++) {
//            for (int col = 1; col < matrix[row].length - 1; col++) {
//                if (onesConnectedToBorder[row][col]) {
//                    continue;
//                }
//
//                matrix[row][col] = 0;
//            }
//        }
//
//        return matrix;
//    }
//
//    private void findOnesConnectedToBorder(int[][] matrix, int startRow, int startCol, boolean[][] onesConnectedToBorder) {
//        Stack<NodeInfo> stack = new Stack<>();
//        stack.push(new NodeInfo(startRow, startCol));
//
//        while (!stack.isEmpty()) {
//            NodeInfo currentPosition = stack.pop();
//
//            boolean alreadyVisited = onesConnectedToBorder[currentPosition.row][currentPosition.col];
//            if (alreadyVisited) {
//                continue;
//            }
//
//            onesConnectedToBorder[currentPosition.row][currentPosition.col] = true;
//
//            List<NodeInfo> neighbors = getNeighbors(matrix, currentPosition.row, currentPosition.col);
//
//            for (NodeInfo neighbor : neighbors) {
//                int row = neighbor.row;
//                int col = neighbor.col;
//
//                if (matrix[row][col] != 1) {
//                    continue;
//                }
//
//                stack.push(neighbor);
//            }
//        }
//    }
//
//    private List<NodeInfo> getNeighbors(int[][] matrix, int row, int col) {
//        List<NodeInfo> neighbors = new ArrayList<>();
//
//        int numRows = matrix.length;
//        int numCols = matrix[row].length;
//
//        if (row - 1 >= 0) { // up
//            neighbors.add(new NodeInfo(row - 1, col));
//        }
//        if (row + 1 < numRows) { // down
//            neighbors.add(new NodeInfo(row + 1, col));
//        }
//        if (col - 1 >= 0) { // left
//            neighbors.add(new NodeInfo(row, col - 1));
//        }
//        if (col + 1 < numCols) { // right
//            neighbors.add(new NodeInfo(row, col + 1));
//        }
//        return neighbors;
//    }
//
//    static class NodeInfo {
//        int row;
//        int col;
//
//        public NodeInfo(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//    }

}
