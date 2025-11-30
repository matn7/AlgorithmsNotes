package november_2025;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesisString {

    public static void main(String[] args) {
//        String s = "(*))";
//        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";

        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        boolean result = validParenthesisString.checkValidString(s);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
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
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }

    // O(n^3) time | O(n^3) space
    public boolean checkValidString2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.charAt(0) == ')') {
            return false;
        }
        Boolean[][] memo = new Boolean[s.length() + 1][s.length() + 1];
        return dfs(s, 0, 0,  memo);
    }

    private boolean dfs(String s, int i, int open, Boolean[][] memo) {
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
            result = dfs(s, i + 1, open + 1, memo);
        } else if (s.charAt(i) == ')') {
            result = dfs(s, i + 1, open - 1, memo);
        } else {
            result = dfs(s, i + 1, open, memo)
                    || dfs(s, i + 1, open + 1, memo)
                    || dfs(s, i + 1, open - 1, memo); // skip || open + 1 || close + 1
        }
        memo[i][open] = result;
        return result;
    }

}
