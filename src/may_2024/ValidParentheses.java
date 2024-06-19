package may_2024;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String str = "{[]}()";


        boolean result = validParentheses(str);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean validParentheses(String str) {
        if (str.isEmpty()) {
            return true;
        }
        if (str.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put(')', '(');
        parensMap.put('}', '{');
        parensMap.put(']', '[');
        Collection<Character> opening = parensMap.values();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (opening.contains(current)) {
                stack.push(current);
            } else if (parensMap.containsKey(current)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character toCompare = parensMap.get(current); // '('
                Character topElement = stack.pop();
                if (toCompare != topElement) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
