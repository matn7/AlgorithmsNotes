package leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Stack<Character> opening = new Stack<>();
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                opening.push(curr);
            } else {
                if (opening.isEmpty()) {
                    continue;
                }
                Character top = opening.pop();
                res += 2;
            }
        }
        return res;
    }
    
}
