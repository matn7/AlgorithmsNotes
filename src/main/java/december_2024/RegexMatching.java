package december_2024;

import java.util.Map;

public class RegexMatching {

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";

        RegexMatching regexMatching = new RegexMatching();
        boolean match = regexMatching.isMatch(s, p);
        System.out.println(match);
    }

    public boolean isMatch(String s, String p) {
        boolean[][] cache = new boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p, cache);
    }

    private boolean dfs(int i, int j, String s, String p, boolean[][] cache) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        if (cache[i][j]) {
            return true;
        }

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            cache[i][j] = dfs(i, j + 2, s, p, cache) ||           // do not use *
                    (match && dfs(i + 1, j, s, p, cache)); // use *
            return cache[i][j];
        }
        if (match) {
            cache[i][j] = dfs(i + 1, j + 1, s, p, cache);
            return cache[i][j];
        }
        return false;
    }


}
