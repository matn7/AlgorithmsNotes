package coderpro;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        String input = "(){([(ab)])}";

        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid(input);
        System.out.println();
    }

    public boolean isValid(String string) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parens = new HashMap<>();
        parens.put('[', ']');
        parens.put('{', '}');
        parens.put('(', ')');

        Map<Character, Character> inversParen = new HashMap<>();
        inversParen.put(']', '[');
        inversParen.put('}', '{');
        inversParen.put(')', '(');


        for (char c : string.toCharArray()) {
            if (parens.containsKey(c)) {
                stack.push(c);
            } else if (inversParen.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != inversParen.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    // O(n) time | O(n) space
    public boolean validParentheses2(String input) {
        if (input.isEmpty()) {
            return true;
        }

        Map<Character, Character> parenMap = new HashMap<>();
        parenMap.put(']', '[');
        parenMap.put(')', '(');
        parenMap.put('}', '{');

        Collection<Character> openingParen = parenMap.values();
        Set<Character> closingParen = parenMap.keySet();

        Stack<Character> parenStack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (openingParen.contains(c)) {
                parenStack.push(c);
            } else if (closingParen.contains(c)) {
                if (parenStack.isEmpty()) {
                    return false;
                }
                Character topElement = parenStack.pop();
                Character toCompare = parenMap.get(c);
                if (topElement != toCompare) {
                    return false;
                }
            }
        }
        return parenStack.isEmpty();
    }

}
