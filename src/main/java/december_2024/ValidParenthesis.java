package december_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String s = "((**)";
        ValidParenthesis validParenthesis = new ValidParenthesis();
        boolean result = validParenthesis.checkValidString(s);
        System.out.println(result);
    }

    public boolean checkValidString(String s) {
        if (s.charAt(0) == ')') {
            return false;
        }
        Map<Integer, Boolean> cache = new HashMap<>();
        return dfs(0, 0, s, cache);
    }

    private boolean dfs(int left, int idx, String s, Map<Integer, Boolean> cache) {

        if (idx == s.length() && left == 0) {
            return true;
        }
        if (left < 0 || idx >= s.length()) {
            return false;
        }
        char c = s.charAt(idx);
        if (c == '(') {
            return dfs(left + 1, idx + 1, s, cache);
        } else if (c == ')') {
            return dfs(left - 1, idx + 1, s, cache);
        } else {
            return dfs(left, idx + 1, s, cache) || dfs(left + 1, idx + 1, s, cache) || dfs(left - 1, idx + 1, s, cache);
        }
    }

    // O(n^2) time | O(n^2) space
    public boolean checkValidString2(String s) {
        if (s.charAt(0) == ')') {
            return false;
        }
        int n = s.length();
        Boolean[][] cache = new Boolean[n + 1][n + 1];
        return dfs(0, 0, s, cache);
    }

    private boolean dfs(int left, int idx, String s, Boolean[][] cache) {
        if (left < 0) {
            return false;
        }
        if (idx == s.length()) {
            return left == 0;
        }
        if (cache[idx][left] != null) {
            return cache[idx][left];
        }
        boolean result;
        char c = s.charAt(idx);
        if (c == '(') {
            result = dfs(left + 1, idx + 1, s, cache);
        } else if (c == ')') {
            result = dfs(left - 1, idx + 1, s, cache);
        } else {
            result = dfs(left, idx + 1, s, cache) ||
                    dfs(left + 1, idx + 1, s, cache) ||
                    dfs(left - 1, idx + 1, s, cache);
        }
        cache[idx][left] = result;
        return result;
    }

}
