package june_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses2 {

    public static void main(String[] args) {
        String s = "()[]{}";

        ValidParentheses2 validParentheses2 = new ValidParentheses2();
        boolean result = validParentheses2.isValid(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put(']', '[');
        parensMap.put('}', '{');
        parensMap.put(')', '(');

        Stack<Character> openStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!parensMap.containsKey(c)) {
                openStack.push(c);
            } else {
                if (openStack.isEmpty()) {
                    return false;
                }
                Character value = openStack.pop();
                Character open = parensMap.get(c);
                if (value != open) {
                    return false;
                }
            }
        }
        return openStack.isEmpty();
    }

}
