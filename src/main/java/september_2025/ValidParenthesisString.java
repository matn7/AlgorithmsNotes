package september_2025;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesisString {

    public static void main(String[] args) {
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        String s = "(*))";
        boolean result = validParenthesisString.checkValidString(s);
        System.out.println(result);
    }

    // O(n^2) time | O(n^2) space
    public boolean checkValidString(String s) {
//        Map<String, Boolean> cache = new HashMap<>();
        Boolean[][] cache = new Boolean[s.length() + 1][s.length() + 1];
        return backtrack(s, 0, 0, cache);
    }

    private boolean backtrack(String s, int i, int open, Boolean[][] cache) {
        if (open < 0) {
            return false;
        }
        if (i == s.length()) {
            return open == 0;
        }
        if (cache[i][open] != null) {
            return cache[i][open];
        }

        boolean result = false;
        if (s.charAt(i) == '*') {
            result = backtrack(s, i + 1, open + 1, cache) || backtrack(s, i + 1, open - 1, cache) ||
                    backtrack(s, i + 1, open, cache);
        } else if (s.charAt(i) == '(') {
            result = backtrack(s, i + 1, open + 1, cache);
        } else {
            result = backtrack(s, i + 1, open - 1, cache);
        }
        cache[i][open] = result;
        return result;
    }

}
