package october_2025;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]{}";

        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put('}', '{');
        parensMap.put(']', '[');
        parensMap.put(')', '(');

        Collection<Character> opening = parensMap.values();
        if (!opening.contains(s.charAt(0))) {
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (opening.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (parensMap.get(c) != top) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
