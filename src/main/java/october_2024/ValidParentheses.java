package october_2024;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "(([]{}()))";

        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put(']', '[');
        parensMap.put('}', '{');
        parensMap.put(')', '(');

        Collection<Character> openingParens = parensMap.values();

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (openingParens.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character open = parensMap.get(c);
                Character stackOpen = stack.pop();
                if (open != stackOpen) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
