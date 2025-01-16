package december_2024;

public class LongestIncreasingPath2 {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {5, 5, 3},
//                {2, 3, 6},
//                {1, 1, 1}
//        };

        // [[9,9,4],[6,6,8],[2,1,1]]
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        LongestIncreasingPath2 longestIncreasingPath = new LongestIncreasingPath2();
        int result = longestIncreasingPath.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i][j] = 1;
            }
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (!visited[r][c]) {
                    dfs(r, c, matrix, dp, visited);
                }
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                max = Math.max(max, dp[r][c]);
            }
        }

        return max;
    }

    private void dfs(int row, int col, int[][] matrix, int[][] dp, boolean[][] visited) {
        visited[row][col] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidPos(newRow, newCol, matrix)) {
                if (matrix[newRow][newCol] > matrix[row][col] && !visited[newRow][newCol]) {
                    dp[row][col] = Math.max(dp[newRow][newCol] + 1, dp[row][col]);
                    dfs(newRow, newCol, matrix, dp, visited);
                }
            }
        }

    }

    private boolean isValidPos(int r, int c, int[][] matrix) {
        return r >= 0 && r <= matrix.length - 1 && c >= 0 && c <= matrix[r].length - 1;
    }

}
