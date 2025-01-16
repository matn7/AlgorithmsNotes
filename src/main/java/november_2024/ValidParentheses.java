package november_2024;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put(')', '(');
        parensMap.put(']', '[');
        parensMap.put('}', '{');
        Stack<Character> openingStack = new Stack<>();
        Collection<Character> openingParens = parensMap.values();

        for (char c : s.toCharArray()) {
            if (openingParens.contains(c)) {
                openingStack.add(c);
            } else {
                if (openingStack.isEmpty()) {
                    return false;
                }
                Character pop = openingStack.pop();
                Character curr = parensMap.get(c);
                if (pop != curr) {
                    return false;
                }
            }
        }

        return openingStack.isEmpty();
    }

}
