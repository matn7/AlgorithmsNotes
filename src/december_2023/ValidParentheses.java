package december_2023;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String str = "()jai{aa(ssd[f])}ahuahau((";

        boolean result = validParentheses(str);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean validParentheses(String str) {
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put(']', '[');
        parensMap.put('}', '{');
        parensMap.put(')', '(');

        Collection<Character> openingParens = parensMap.values();

        Stack<Character> stack = new Stack<>();

        for (char character : str.toCharArray()) {
            if (openingParens.contains(character)) {
                // opening parenthesis
                stack.push(character);
            } else if (parensMap.containsKey(character)) {
                // closing parenthesis
                if (stack.isEmpty()) {
                    return false;
                }
                Character topElement = stack.pop(); // (
                Character toCompare = parensMap.get(character); // (
                if (topElement != toCompare) {
                    return false;
                }
            }
            // else other chars
        }


        return stack.isEmpty();
    }

}
