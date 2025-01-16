package november_2024;

public class LongestIncreasingPathInMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
//
//        int[][] matrix = {
//                {3, 4, 5},
//                {3, 2, 6},
//                {2, 2, 1}
//        };

        // [[3,4,5],[3,2,6],[2,2,1]]

        LongestIncreasingPathInMatrix longestIncreasingPathInMatrix = new LongestIncreasingPathInMatrix();
        longestIncreasingPathInMatrix.longestIncreasingPath(matrix);
    }

    // ********
    // * STAR *
    // ********

    public int longestIncreasingPath(int[][] matrix) {
        int[][] pathMatrix = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (pathMatrix[r][c] == 0) {
                    pathMatrix[r][c] = 1;
                    explore(matrix, r, c, pathMatrix);
                }
                max = Math.max(max, pathMatrix[r][c]);
            }
        }

        return max;

    }

    private void explore(int[][] matrix, int r, int c, int[][] pathMatrix) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int currPos = matrix[r][c];
        for (int[] direction : directions) {
            int newRow = r + direction[0];
            int newCol = c + direction[1];

            if (isValidPos(newRow, newCol, matrix) && currPos > matrix[newRow][newCol]
                    && pathMatrix[newRow][newCol] + 1 > pathMatrix[r][c]) {
                pathMatrix[r][c] = pathMatrix[newRow][newCol] + 1;
//                explore(matrix, newRow, newCol, pathMatrix);
            }
        }
    }

    private boolean isValidPos(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }

}
