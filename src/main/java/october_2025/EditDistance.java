package october_2025;

public class EditDistance {

    public static void main(String[] args) {
//        String word1 = "horse";
//        String word2 = "ros";

        String word1 = "intention", word2 = "execution";

        EditDistance editDistance = new EditDistance();
        int result = editDistance.minDistance(word1, word2);
        System.out.println(result);
    }

    // O(n * m) time | O(n * m) space
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int r = 0; r < dp.length; r++) {
            dp[r][0] = r;
        }
        for (int c = 0; c < dp[0].length; c++) {
            dp[0][c] = c;
        }
        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[r].length; c++) {
                if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = 1 + Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
