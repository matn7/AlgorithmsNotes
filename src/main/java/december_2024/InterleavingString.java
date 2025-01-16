package december_2024;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        InterleavingString interleavingString = new InterleavingString();
        boolean result = interleavingString.isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        Map<String, Boolean> dp = new HashMap<>();
        return dfs(0, 0, s1, s2, s3, dp);
    }

    private boolean dfs(int i, int j, String s1, String s2, String s3, Map<String, Boolean> dp) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        String key = i + ":" + j;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfs(i + 1, j, s1, s2, s3, dp)) {
            return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dfs(i, j + 1, s1, s2, s3, dp)) {
            return true;
        }
        dp.put(key, false);
        return false;
    }

}
