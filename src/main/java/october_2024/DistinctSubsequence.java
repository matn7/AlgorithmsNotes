package october_2024;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequence {

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        DistinctSubsequence distinctSubsequence = new DistinctSubsequence();
        int result = distinctSubsequence.numDistinct(s, t);
        System.out.println(result);
    }

    // leetcode 115

    // O(n*m) time | O(n*m) space
    public int numDistinct(String s, String t) {
        Map<String, Integer> cache = new HashMap<>();
        return dfs(0, 0, s, t, cache);
    }

    private int dfs(int i, int j, String s, String t, Map<String, Integer> cache ) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        String key = i + ":" + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (s.charAt(i) == t.charAt(j)) {
            cache.put(key, dfs(i + 1, j + 1, s, t, cache) + dfs(i + 1, j, s, t, cache));
        } else {
            cache.put(key, dfs(i + 1, j, s, t, cache));
        }
        return cache.get(key);
    }

    public int numDistinct2(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        dp[0][0] = 1;

        for (int row = 1; row < dp.length; row++) {
            char curr = t.charAt(row - 1);
            for (int col = 1; col < dp[row].length; col++) {
                if (curr == s.charAt(col - 1)) {
                    int diagonal = dp[row - 1][col - 1];
                    int left = dp[row][col - 1];
                    if (left == 0) {
                        dp[row][col] = diagonal;
                    } else if (diagonal == 0) {
                        dp[row][col] = dp[row][col - 1] + 1;
                    } else {
                        dp[row][col] = diagonal + 1;
                    }
                }
            }
        }

        return dp[t.length()][s.length()];
    }

}
