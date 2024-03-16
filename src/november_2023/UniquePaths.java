package november_2023;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(5, 3));
    }

    // O(n*m) time | O(n*m) space
    public static int uniquePaths(int m, int n) {
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

        return path[m - 1][n - 1];
    }

    // O(2^n*m) time | O(2^n*m) space
    public static int uniquePathsV2(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePathsV2(m - 1, n) + uniquePathsV2(m, n - 1);
    }



}
