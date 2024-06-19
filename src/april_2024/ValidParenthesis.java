package april_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

        ValidParenthesis validParenthesis = new ValidParenthesis();
        boolean result = validParenthesis.isValid("{[()]}{}[");
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char digit = s.charAt(i);
            if (brackets.containsKey(digit)) {
                stack.push(digit);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char last_open = stack.pop();
                if (brackets.get(last_open) != digit) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
