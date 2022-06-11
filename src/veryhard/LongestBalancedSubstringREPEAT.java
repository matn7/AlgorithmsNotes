package veryhard;

import java.util.Map;
import java.util.Stack;

public class LongestBalancedSubstringREPEAT {

    public static void main(String[] args) {
        String string = "(()))(";

        LongestBalancedSubstringREPEAT balancedSubstring = new LongestBalancedSubstringREPEAT();
        balancedSubstring.longestBalancedSubstring(string);
    }

    // OK - repeated 23/02/2022
    // O(n) time | O(1) space
    public int longestBalancedSubstring(String string) {
        return Math.max(getLongestBalancedInDirection(string, true),
                getLongestBalancedInDirection(string, false)); // max(4, )
    }

    // rec("(()))(", false)
    private int getLongestBalancedInDirection(String string, boolean leftToRight) {
        char openingParens = leftToRight ? '(' : ')'; // )
        int startIdx = leftToRight ? 0 : string.length() - 1; // 5
        int step = leftToRight ? 1 : -1; // -1
        int maxLength = 0;

        int openingCount = 0;
        int closingCount = 0;

        int idx = startIdx; // 5
        // 0 1 2 3 4 5
        //   *
        // ( ( ) ) ) (
        while (idx >= 0 && idx < string.length()) {
            char character = string.charAt(idx); // (

            if (character == openingParens) { // ( == )
                openingCount++; // 3
            } else {
                closingCount++; // 0
            }

            if (openingCount == closingCount) { // 1 == 0
                maxLength = Math.max(maxLength, closingCount * 2); // max(0, 4) = 4
            } else if (closingCount > openingCount) { // 3 > 2
                openingCount = 0;
                closingCount = 0;
            }

            idx += step;
        }
        return maxLength;
    }


//    // O(n) time | O(1) space
//    public int longestBalancedSubstring(String string) {
//        int maxLength = 0;
//
//        int openingCount = 0;
//        int closingCount = 0;
//
//        for (char character : string.toCharArray()) {
//            if (character == '(') {
//                openingCount++;
//            } else {
//                closingCount++;
//            }
//
//            if (openingCount == closingCount) {
//                maxLength = Math.max(maxLength, closingCount * 2);
//            } else if (closingCount > openingCount) {
//                openingCount = 0;
//                closingCount = 0;
//            }
//        }
//
//        openingCount = 0;
//        closingCount = 0;
//
//        for (int i = string.length() - 1; i >= 0; i--) {
//            char character = string.charAt(i);
//            if (character == '(') {
//                openingCount++;
//            } else {
//                closingCount++;
//            }
//
//            if (openingCount == closingCount) {
//                maxLength = Math.max(maxLength, openingCount * 2);
//            } else if (openingCount > closingCount) {
//                openingCount = 0;
//                closingCount = 0;
//            }
//        }
//
//        return maxLength;
//    }

//    // O(n) time | O(n) space
//    // rec("(()))(")
//    public int longestBalancedSubstring(String string) {
//        int maxLength = 0;
//        Stack<Integer> idxStack = new Stack<>();
//        idxStack.add(-1);
//
//        // ----------------------------
//        // |
//        // ----------------------------
//
//        // 0 1 2 3 4 5
//        //         i
//        // ( ( ) ) ) (
//        for (int i = 0; i < string.length(); i++) {
//            if (string.charAt(i) == '(') {
//                idxStack.add(i);
//            } else {
//                idxStack.pop();
//                if (idxStack.isEmpty()) {
//                    idxStack.add(i);
//                } else {
//                    Integer balancedSubstringStartIdx = idxStack.peek(); // -1
//                    int currentLength = i - balancedSubstringStartIdx; // 3 - (-1) = 4
//                    maxLength = Math.max(maxLength, currentLength); // max(2, 4) = 4
//                }
//            }
//        }
//        return maxLength; // 4
//    }

//    // O(n^3) time | O(n) space
//    public int longestBalancedSubstring(String string) {
//        int maxLength = 0;
//
//        // 0 1 2 3 4 5
//        //   i
//        // ( ( ) ) ) (
//        //           j
//        for (int i = 0; i < string.length(); i++) {
//            for (int j = i + 2; j < string.length() + 1; j += 2) {
//                // rec("( ) ) )")
//                if (isBalanced(string.substring(i,j))) {
//                    int currentLength = j - i; // 3 - 1 = 2
//                    maxLength = Math.max(maxLength, currentLength); // max(4, 2) = 4
//                }
//            }
//        }
//        return maxLength;
//    }
//
//    private boolean isBalanced(String string) {
//        Stack<Character> openParenStack = new Stack<>();
//
//        //     *
//        // ( ) ) )
//        for (char character : string.toCharArray()) {
//            if (character == '(') {
//                openParenStack.add('('); //
//            } else if (!openParenStack.isEmpty()) {
//                openParenStack.pop();
//            } else {
//                return false;
//            }
//        }
//
//        return openParenStack.size() == 0;
//    }

}
