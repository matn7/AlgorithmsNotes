package may_2025;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "{([]){}]";
        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put('}', '{');
        parensMap.put(']', '[');
        parensMap.put(')', '(');
        Set<Character> opening = new HashSet<>(parensMap.values());
        Stack<Character> openStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (opening.contains(c)) {
                openStack.add(c);
            } else {
                if (openStack.isEmpty()) {
                    return false;
                }
                Character open = openStack.pop(); // (
                Character currOpen = parensMap.get(c); // )
                if (open != currOpen) {
                    return false;
                }
            }
        }
        return openStack.isEmpty();
    }

}
