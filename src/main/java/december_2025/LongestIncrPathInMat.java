package december_2025;

public class LongestIncrPathInMat {

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

//        int[][] matrix = {
//                {3, 4, 5},
//                {3, 2, 6},
//                {2, 2, 1}
//        };

        LongestIncrPathInMat longestIncrPathInMat = new LongestIncrPathInMat();
        int result = longestIncrPathInMat.longestIncreasingPath(matrix);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int maxPath = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                maxPath = Math.max(maxPath, dfs(matrix, r, c, dp, -1));
            }
        }

        return maxPath;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] dp, int prevVal) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || matrix[r][c] <= prevVal) {
            return 0;
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 1;
        for (int[] dir : directions) {
            count = Math.max(count, 1 + dfs(matrix, r + dir[0], c + dir[1], dp, matrix[r][c]));
        }
        dp[r][c] = count;
        return count;
    }
}
