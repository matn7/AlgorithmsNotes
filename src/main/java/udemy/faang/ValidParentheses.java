package udemy.faang;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String string = "{([])}";
        boolean result = validParentheses(string);
        System.out.println(result);

        boolean result2 = isValidParentheses(string);
        System.out.println(result2);
    }

    // O(n) time | O(n) space
    public static boolean validParentheses(String string) {
        if (string.isEmpty()) {
            return true;
        }
        if (string.length() == 1) {
            return false;
        }

        Stack<Character> openingStack = new Stack<>();
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(']', '[');
        matchingBrackets.put(')', '(');
        matchingBrackets.put('}', '{');
        Collection<Character> openingBrackets = matchingBrackets.values();

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (openingBrackets.contains(currentChar)) {
                openingStack.push(currentChar);
            } else if (matchingBrackets.containsKey(currentChar)) {
                if (openingStack.isEmpty()) {
                    return false;
                }
                Character topElement = openingStack.pop();
                Character matchingBracket = matchingBrackets.get(currentChar);
                if (topElement != matchingBracket) {
                    return false;
                }
            }
        }
        return openingStack.isEmpty();
    }

    static Map<Character, Character> parens = new HashMap<>();

    static {
        parens.put('(', ')');
        parens.put('[', ']');
        parens.put('{', '}');
    }

    // O(n) time | O(n) space
    public static boolean isValidParentheses(String string) {
        if (string.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (parens.containsKey(string.charAt(i))) {
                stack.push(string.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char leftBracket = stack.pop();
                char correctBracket = parens.get(leftBracket);
                if (string.charAt(i) != correctBracket) {
                    return false;
                }
            }
        }
        return true;
    }

}
