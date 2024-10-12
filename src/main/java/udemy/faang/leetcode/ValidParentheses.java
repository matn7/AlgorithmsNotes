package udemy.faang.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Map<Character, Character> parenMap = new HashMap<>();
        parenMap.put(')', '(');
        parenMap.put(']', '[');
        parenMap.put('}', '{');

        Collection<Character> opening = parenMap.values();
        Stack<Character> openingStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (opening.contains(current)) {
                openingStack.push(current);
            } else {
                if (openingStack.isEmpty()) {
                    return false;
                }
                Character top = openingStack.pop();
                Character toCompare = parenMap.get(current);
                if (top != toCompare) {
                    return false;
                }
            }
        }
        return openingStack.isEmpty();
    }
}
