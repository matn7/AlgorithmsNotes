package april_2025;

public class RegularExpressionMatching {

    // O(n * m) time | O(n * m) space
    public boolean isMatch(String s, String p) {
        // top-down memoization
        Boolean[][] cache = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p, cache);
    }

    private boolean dfs(int i, int j, String s, String p, Boolean[][] cache) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        boolean match = i < s.length() && ((s.charAt(i) == p.charAt(j)) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            cache[i][j] = dfs(i, j + 2, s, p, cache) || // dont use *
                    (match && dfs(i + 1, j, s, p, cache)); // use *
            return cache[i][j];
        }
        if (match) {
            cache[i][j] = dfs(i + 1, j + 1, s, p, cache);
            return cache[i][j];
        }
        cache[i][j] = false;
        return false;
    }

}
