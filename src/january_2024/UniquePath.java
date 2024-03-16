package january_2024;

public class UniquePath {

    public static void main(String[] args) {
        System.out.println(uniquePath(3, 4));
        System.out.println(uniquePath2(3, 4));
    }

    // O(2^(m*n)) time | O(2^(m*n)) space
    public static int uniquePath(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePath(m - 1, n) + uniquePath(m, n - 1);
    }

    // O(n*m) time | O(n*m) space
    public static int uniquePath2(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < cache.length; i++) {
            cache[i][0] = 1;
        }
        for (int i = 0; i < cache[0].length; i++) {
            cache[0][i] = 1;
        }

        for (int i = 1; i < cache.length; i++) {
            for (int j = 1; j < cache[i].length; j++) {
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }

        return cache[m - 1][n - 1];
    }

}
