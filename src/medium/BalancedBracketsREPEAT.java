package medium;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBracketsREPEAT {

    public static void main(String[] args) {
        String input = "{()()}[]";

        boolean result = balancedBrackets(input);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    // OK - repeated 12/02/2022
    public static boolean balancedBrackets(String str) {
        // Write your code here.
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put('}', '{');
        matchingBrackets.put(']', '[');

        // matchingBrackets = {')': '(', '}': '{', ']': '['}
        Collection<Character> openingBrackets = matchingBrackets.values();

        // openingBrackets = ['(', '{', '[']
        Stack<Character> openingBracketsStack = new Stack<>();

        // --------------------
        // |
        // --------------------
        //                *
        // "{ ( ) ( ) } [ ]"
        for (Character character : str.toCharArray()) { // ]
            if (openingBrackets.contains(character)) {
                openingBracketsStack.push(character); //
            }

            if (matchingBrackets.containsKey(character)) { // ]
                // closing
                if (openingBracketsStack.isEmpty()) {
                    return false;
                }
                Character opening = openingBracketsStack.pop(); // [
                Character openingFromMap = matchingBrackets.get(character); // [
                if (opening != openingFromMap) {
                    return false;
                }
            }
        }
        return openingBracketsStack.isEmpty(); // true
    }


}
