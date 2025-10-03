package october_2025;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesisString {

    public static void main(String[] args) {
//        String s = "(*)";
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";

        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        boolean result = validParenthesisString.checkValidString(s);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) { // s = ( * ) (
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }

    // O(n*m) time | O(n*m) space
    public boolean checkValidString2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.charAt(0) == ')') {
            return false;
        }
        Map<String, Boolean> memo = new HashMap<>();
        return helper(s, 0, 0, memo);
    }

    private boolean helper(String s, int i, int open, Map<String, Boolean> memo) {
        if (i == s.length()) {
            return open == 0;
        }
        if (open < 0) {
            return false;
        }
        String key = i + ":" + open;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean result = false;
        if (s.charAt(i) == '(') {
            result = helper(s, i + 1, open + 1, memo);
        } else if (s.charAt(i) == ')') {
            result = helper(s, i + 1, open - 1, memo);
        } else {
            result = helper(s, i + 1, open + 1, memo) || helper(s, i + 1, open - 1, memo) || helper(s, i + 1, open, memo);
        }
        memo.put(key, result);
        return result;
    }

}
