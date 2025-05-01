package april_2025;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "{}{}{(([]))}";

        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        Stack<Character> openingStack = new Stack<>();
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put('}', '{');
        parensMap.put(']', '[');
        parensMap.put(')', '(');

        String opening = "{[(";

        for (char c : s.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                openingStack.push(c);
            } else {
                if (openingStack.isEmpty()) {
                    return false;
                }
                Character open = openingStack.pop();
                Character openToCheck = parensMap.get(c);
                if (open != openToCheck) {
                    return false;
                }
            }
        }
        return openingStack.isEmpty();
    }

}
