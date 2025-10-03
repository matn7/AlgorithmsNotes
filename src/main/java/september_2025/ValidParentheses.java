package september_2025;

import java.util.*;

public class ValidParentheses {

    // O(n) time | O(n) space
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put('(', ')');
        parensMap.put('{', '}');
        parensMap.put('[', ']');

        Deque<Character> queue = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (parensMap.containsKey(c)) {
                queue.addLast(c);
            } else {
                if (queue.isEmpty()) {
                    return false;
                }
                char top = queue.removeLast();
                char close = parensMap.get(top);
                if (close != c) {
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }

}
