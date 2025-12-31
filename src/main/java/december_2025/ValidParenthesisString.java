package december_2025;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesisString {

    public static void main(String[] args) {
        String s = "(*))";

        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        boolean result = validParenthesisString.checkValidString(s);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftMin++;
                leftMax++;
            } else if (s.charAt(i) == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }

        return leftMin == 0;
    }

    // O(n^3) time | O(n^2) space
    public boolean checkValidString2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.charAt(0) == ')') {
            return false;
        }
        Boolean[][] memo = new Boolean[s.length()][s.length()];
        return backtrack(0, 0, s, memo);
    }

    private boolean backtrack(int open, int i, String s, Boolean[][] memo) {
        if (open < 0) {
            return false;
        }
        if (i == s.length()) {
            return open == 0;
        }
        if (memo[i][open] != null) {
            return memo[i][open];
        }
        boolean result = false;
        if (s.charAt(i) == '(') {
            result = backtrack(open + 1, i + 1, s, memo);
        } else if (s.charAt(i) == ')') {
            result = backtrack(open - 1, i + 1, s, memo);
        } else {
            result = backtrack(open + 1, i + 1, s, memo) || backtrack(open - 1, i + 1, s, memo) || backtrack(open, i + 1, s, memo);
        }
        memo[i][open] = result;
        return result;
    }

}
