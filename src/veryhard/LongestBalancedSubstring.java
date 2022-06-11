package veryhard;

import java.util.Stack;

public class LongestBalancedSubstring {

    public static void main(String[] args) {
        String string = "(()))(";

        LongestBalancedSubstring balancedSubstring = new LongestBalancedSubstring();
        balancedSubstring.longestBalancedSubstring(string);
    }

    // O(n) time | O(1) space
    public int longestBalancedSubstring(String string) {
        return Math.max(getLongestBalancedInDirection(string, true),
                getLongestBalancedInDirection(string, false));
    }

    public int getLongestBalancedInDirection(String string, boolean leftToRight) {
        char openingParens;
        int startIdx;
        int step;
        if (leftToRight) {
            openingParens = '(';
            startIdx = 0;
            step = 1;
        } else {
            openingParens = ')';
            startIdx = string.length() - 1;
            step = -1;
        }
        int maxLength = 0;
        int openingCount = 0;
        int closingCount = 0;

        int idx = startIdx;
        while (idx >= 0 && idx < string.length()) {
            char character = string.charAt(idx);
            if (character == openingParens) {
                openingCount++;
            } else {
                closingCount++;
            }
            if (openingCount == closingCount) {
                maxLength = Math.max(maxLength, closingCount * 2);
            } else if (closingCount > openingCount) {
                openingCount = 0;
                closingCount = 0;
            }
            idx += step;
        }

        return maxLength;
    }

//    // O(n) time | O(1) space
//    public int longestBalancedSubstring(String string) {
//        // Write your code here.
//        int maxLength = 0;
//        int openingCount = 0;
//        int closingCount = 0;
//
//        for (char character : string.toCharArray()) {
//            if (character == '(') {
//                openingCount++;
//            } else {
//                closingCount++;
//            }
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
//        return maxLength;
//    }

//    // O(n) time | O(n) space
//    public int longestBalancedSubstring(String string) {
//        // Write your code here.
//        int maxLength = 0;
//        Stack<Integer> idxStack = new Stack<>();
//        idxStack.add(-1);
//
//        for (int i = 0; i < string.length(); i++) {
//            if (string.charAt(i) == '(') {
//                idxStack.add(i);
//            } else {
//                idxStack.pop();
//                if (idxStack.size() == 0) {
//                    idxStack.add(i);
//                } else {
//                    Integer balancedSubstringStartIdx = idxStack.peek();
//                    int currentLength = i - balancedSubstringStartIdx;
//                    maxLength = Math.max(maxLength, currentLength);
//                }
//            }
//        }
//        return maxLength;
//    }

//    // O(n^3) time | O(n) space
//    public int longestBalancedSubstring(String string) {
//        // Write your code here.
//        int maxLength = 0;
//        for (int i = 0; i < string.length(); i++) {
//            for (int j = i + 2; j < string.length() + 1; j += 2) {
//                if (isBalanced(string.substring(i, j))) {
//                    int currentLength = j - i;
//                    maxLength = Math.max(maxLength, currentLength);
//                }
//            }
//        }
//        return maxLength;
//    }
//
//    private boolean isBalanced(String string) {
//        Stack<Character> openParensStack = new Stack<>();
//        for (char character : string.toCharArray()) {
//            if (character == '(') {
//                openParensStack.add('(');
//            } else if (openParensStack.size() > 0) {
//                openParensStack.pop();
//            } else {
//                return false;
//            }
//        }
//        return openParensStack.size() == 0;
//    }

}
