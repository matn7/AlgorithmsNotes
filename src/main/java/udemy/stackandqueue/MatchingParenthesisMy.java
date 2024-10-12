package udemy.stackandqueue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MatchingParenthesisMy {

    public static void main(String[] args) {
        String string = "(ABC){DEF}[XYZ(LMN)]]";

        try {
            boolean result = matchingParenthesis(string);
            System.out.println();
        } catch (Stack.StackOverflowException e) {
            e.printStackTrace();
        } catch (Stack.StackUnderflowException e) {
            e.printStackTrace();
        }
    }

    // O(n) time
    public static boolean matchingParenthesis(String string) throws Stack.StackOverflowException, Stack.StackUnderflowException {
        Map<Character, Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put('}', '{');
        parenthesisMap.put(']', '[');
        parenthesisMap.put(')', '(');

        Collection<Character> openingBrackets = parenthesisMap.values();
        Stack<Character> openingStack = new Stack<>();

        for (char element : string.toCharArray()) {
            if (openingBrackets.contains(element)) {
                openingStack.push(element);
            } else if (parenthesisMap.containsKey(element)) {
                if (openingStack.isEmpty()) {
                    return false;
                }
                Character topElement = openingStack.pop();
                Character toCompare = parenthesisMap.get(element);
                if (topElement != toCompare) {
                    return false;
                }
            }
        }
        return openingStack.isEmpty();
    }

}
