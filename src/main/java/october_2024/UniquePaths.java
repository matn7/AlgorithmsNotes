package october_2024;

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePaths(m, n);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int uniquePaths(int m, int n) {

        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                paths[r][c] = paths[r][c - 1] + paths[r - 1][c];
            }
        }
        return paths[m - 1][n - 1];
    }

}
