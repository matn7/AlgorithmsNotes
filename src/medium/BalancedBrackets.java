package medium;

import java.util.*;

public class BalancedBrackets {

    private static Map<Character, Character> matchingParenthesis = new HashMap<>();
    private static Set<Character> openingBracket = new HashSet<>();

    static {
        matchingParenthesis.put(')', '(');
        matchingParenthesis.put(']', '[');
        matchingParenthesis.put('}', '{');

        openingBracket.addAll(matchingParenthesis.values());
    }

    public static void main(String[] args) {
//        String input = "{()()}[]";
        String input = ")[]}";

        boolean result = balancedBrackets(input);
        System.out.println(result);
    }

    public static boolean balancedBrackets(String str) {
        // Write your code here.
        LinkedList<Character> openingStack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (openingBracket.contains(str.charAt(i))) {
                openingStack.push(str.charAt(i)); // { (
            }

            if (matchingParenthesis.containsKey(str.charAt(i))) {
                if (openingStack.isEmpty()) {
                    return false;
                }
                Character bracketPair = matchingParenthesis.get(str.charAt(i)); // ')' : '('
                Character bracketFromStack = openingStack.pop(); // (
                if (bracketPair != bracketFromStack) {
                    return false;
                }
            }
        }

        return openingStack.isEmpty();
    }


}
