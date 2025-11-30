package november_2025;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()";
        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        Map<Character, Character> openToClose = new HashMap<>();
        openToClose.put('(', ')');
        openToClose.put('{', '}');
        openToClose.put('[', ']');

        ArrayDeque<Character> openStack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (openToClose.containsKey(c)) {
                openStack.addLast(c);
            } else {
                if (openStack.isEmpty()) {
                    return false;
                }
                Character open = openStack.removeLast();
                Character expectedClose = openToClose.get(open);
                if (c != expectedClose) {
                    return false;
                }
            }
        }
        return openStack.isEmpty();
    }

}
