package october_2024;

public class EditDistance {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        EditDistance editDistance = new EditDistance();
        int result = editDistance.minDistance(word1, word2);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];

        for (int row = 0; row < dp.length; row++) {
            dp[row][0] = row;
        }

        for (int col = 0; col < dp[0].length; col++) {
            dp[0][col] = col;
        }

        for (int row = 1; row < dp.length; row++) {
            char currRow = word2.charAt(row - 1);
            for (int col = 1; col < dp[row].length; col++) {
                char currCol = word1.charAt(col - 1);
                if (currRow == currCol) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    int left = dp[row][col - 1];
                    int up = dp[row - 1][col];
                    int diagonal = dp[row - 1][col - 1];
                    if (left < up && left < diagonal) {
                        dp[row][col] = left + 1;
                    } else if (up < left && up < diagonal) {
                        dp[row][col] = up + 1;
                    } else {
                        dp[row][col] = diagonal + 1;
                    }
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }

}
