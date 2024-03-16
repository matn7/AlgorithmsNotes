package november_2023;

public class UniquePathsV2 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(5, 3));
    }

    // O(n*m) time | O(n*m) space
    public static int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int row = 0; row < m; row++) {
            paths[row][0] = 1;
        }
        for (int col = 0; col < n; col++) {
            paths[0][col] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                paths[row][col] = paths[row - 1][col] + paths[row][col - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

}
