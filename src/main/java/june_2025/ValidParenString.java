package june_2025;

import java.util.HashMap;
import java.util.Map;

public class ValidParenString {

    public static void main(String[] args) {
        ValidParenString validParenString = new ValidParenString();
        String s = "(*))";
        boolean result = validParenString.checkValidString(s);
        System.out.println(result);
    }

    // O(n^2) time | O(n^2) space
    public boolean checkValidString(String s) {
        Map<String, Boolean> cache = new HashMap<>();
        return backtrack(s, 0, 0,  cache);
    }

    private boolean backtrack(String s, int i, int open, Map<String, Boolean> cache) {
        if (open < 0) {
            return false;
        }
        if (i == s.length()) {
            return open == 0;
        }
        String key = i + ":" + open;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        char c = s.charAt(i);
        boolean result = false;
        if (c == '*') {
            result = backtrack(s, i + 1, open + 1, cache) || backtrack(s, i + 1, open, cache)
                    || backtrack(s, i + 1, open - 1, cache);
        } else if (c == '(') {
            result = backtrack(s, i + 1, open + 1, cache);
        } else {
            result = backtrack(s, i + 1, open - 1, cache);
        }

        cache.put(key, result);
        return result;
    }

}
