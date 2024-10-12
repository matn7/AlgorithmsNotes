package september_2023;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
//        String str = "(aad(d[]rew)f{ggg})s{ad{daa}}[({})ddas]";
        String str = "(()())((()()()))";

        balancedBrackets(str);
    }

    // O(n) time | O(n) space
    public static boolean balancedBrackets(String str) {
        // Write your code here.
        Map<Character, Character> matchingParens = new HashMap<>();
        matchingParens.put(')', '(');
        matchingParens.put('}', '{');
        matchingParens.put(']', '[');
        Collection<Character> openingParens = matchingParens.values();
        Stack<Character> openingStack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (openingParens.contains(c)) {
                openingStack.push(c);
            } else if (matchingParens.containsKey(c)) {
                if (openingStack.isEmpty()) {
                    return false;
                }
                Character topValue = openingStack.pop(); // [
                Character toCompare = matchingParens.get(c); // (
                if (topValue != toCompare) {
                    return false;
                }
            }
        }
        return openingStack.isEmpty();
    }

}
