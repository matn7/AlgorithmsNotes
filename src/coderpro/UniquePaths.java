package coderpro;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePaths(5, 3);
        System.out.println(result);


    }

    // O(2^(m*n)) time | O(2^(m*n)) space
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    // O(m*n) time | O(m*n) space
    public int uniquePaths2(int m, int n) {
        int[][] path = new int[m][n];
        for (int i = 0; i < n; i++) {
            path[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                path[row][col] = path[row - 1][col] + path[row][col - 1];
            }
        }
        return path[m-1][n-1];
    }
}
