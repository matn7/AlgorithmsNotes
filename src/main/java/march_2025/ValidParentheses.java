package march_2025;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "{((){})[]}";
        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Set<Character> opening = Set.of('{', '[', '(');
        Map<Character, Character> mapping = Map.of('}', '{', ']', '[', ')', '(');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (opening.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                char close = mapping.get(c);
                if (open != close) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
