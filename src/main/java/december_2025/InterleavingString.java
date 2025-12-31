package december_2025;

public class InterleavingString {

    // O(n * m) time | O(n * m) space
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return helper(s1, 0, s2, 0, s3, memo);
    }

    private boolean helper(String s1, int i, String s2, int j, String s3, Boolean[][] memo) {
        int k = i + j;
        if (k == s3.length()) {
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = helper(s1, i + 1, s2, j, s3, memo);
            if (result) {
                return true;
            }
        }

        if (!result && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = helper(s1, i, s2, j + 1, s3, memo);
        }
        memo[i][j] = result;
        return result;
    }

}
