package july_2025;

import java.util.*;

public class ValidParentheses {

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parens = new HashMap<>();
        parens.put('}', '{');
        parens.put(']', '[');
        parens.put(')', '(');
        Set<Character> opening = Set.of('{', '[', '(');

        for (char c : s.toCharArray()) {
            if (opening.contains(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char open1 = stack.pop();
                char open2 = parens.get(c);
                if (open1 != open2) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
