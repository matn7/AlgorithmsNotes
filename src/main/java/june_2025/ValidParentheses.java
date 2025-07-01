package june_2025;

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
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put(']', '[');
        parensMap.put('}', '{');
        parensMap.put(')', '(');
        Set<Character> opening = Set.of('[', '{', '(');
        Stack<Character> openingStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (opening.contains(c)) {
                openingStack.add(c);
            } else {
                if (openingStack.isEmpty()) {
                    return false;
                }
                Character open = openingStack.pop();
                Character openToMatch = parensMap.get(c);
                if (open != openToMatch) {
                    return false;
                }
            }
        }
        return openingStack.isEmpty();
    }

}
