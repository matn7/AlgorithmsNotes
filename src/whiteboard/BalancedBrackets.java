package whiteboard;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        String str = "panda{([])(){}panda(())()()}";

        boolean balanced = balancedBrackets(str);
        System.out.println(balanced);
    }

    // O(n) time | O(n) space
    public static boolean balancedBrackets(String str) {
        // Write your code here.
        if (str.length() == 1) {
            return false;
        }
        char[] strChr = str.toCharArray();

        Map<Character, Character> matchingParenMap = new HashMap<>();
        matchingParenMap.put(')', '(');
        matchingParenMap.put(']', '[');
        matchingParenMap.put('}', '{');

        Collection<Character> openingSet = matchingParenMap.values();

        Stack<Character> openingStack = new Stack<>();

        for (char curr : strChr) {
            if (matchingParenMap.containsKey(curr)) {
                if (openingStack.isEmpty()) {
                    return false;
                }
                Character onStack = openingStack.pop();
                Character match = matchingParenMap.get(curr);
                if (onStack != match) {
                    return false;
                }
            } else if (openingSet.contains(curr)) {
                openingStack.push(curr);
            }
        }
        return openingStack.isEmpty();
    }

}
