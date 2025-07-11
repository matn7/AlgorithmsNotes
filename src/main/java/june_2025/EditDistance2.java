package june_2025;

public class EditDistance2 {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        EditDistance2 editDistance2 = new EditDistance2();
        int result = editDistance2.minDistance(word1, word2);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];

        for (int r = 0; r < dp.length; r++) {
            dp[r][0] = r;
        }
        for (int c = 0; c < dp[0].length; c++) {
            dp[0][c] = c;
        }

        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                if (word2.charAt(r - 1) == word1.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = 1 + Math.min(dp[r - 1][c], Math.min(dp[r - 1][c - 1], dp[r][c - 1]));
                }
            }
        }

        return dp[word2.length()][word1.length()];
    }

}
