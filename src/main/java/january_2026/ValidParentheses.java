package january_2026;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        Map<Character, Character> openToClose = new HashMap<>();
        openToClose.put('(', ')');
        openToClose.put('[', ']');
        openToClose.put('{', '}');

        LinkedList<Character> openingStack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (openToClose.containsKey(curr)) {
                openingStack.addLast(curr);
            } else {
                if (openingStack.isEmpty()) {
                    return false;
                }
                char expectedClose = openToClose.get(openingStack.removeLast());
                if (expectedClose != curr) {
                    return false;
                }
            }
        }
        return openingStack.isEmpty();
    }

}
