package february_2025;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePaths(3, 7);
        System.out.println(result);
    }

    // O(n * m) time | O(n) space
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];

        for (int r = m - 1; r >= 0; r--) {
            int[] curRow = new int[n];
            curRow[n - 1] = 1;
            for (int c = n - 2; c >= 0; c--) {
                curRow[c] = curRow[c + 1] + prevRow[c];
            }
            prevRow = curRow;
        }

        return prevRow[0];
    }

    // O(n * m) time | O(m * n) space
    public int uniquePaths2(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            cache[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            cache[0][i] = 1;
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                cache[r][c] = cache[r][c - 1] + cache[r - 1][c];
            }
        }
        return cache[m - 1][n - 1];
    }

}
