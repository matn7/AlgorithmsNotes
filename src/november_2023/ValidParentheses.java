package november_2023;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String str = "(){([(ab)])}";

        boolean result = validParentheses(str);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean validParentheses(String str) {
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put(')', '(');
        parensMap.put(']', '[');
        parensMap.put('}', '{');

        Collection<Character> opening = parensMap.values();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (opening.contains(c)) {
                stack.push(c);
            } else if (parensMap.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character closing = parensMap.get(c);
                Character top = stack.pop();
                if (closing != top) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
