package whiteboard;

import java.util.Stack;

public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        String string = "AlgoExpert  is  the    best!";
        reverseWordsInString.reverseWordsInString(string);
    }

    // O(n) time | O(n) space
    public String reverseWordsInString(String string) {
        // Write your code here.
        Stack<String> stack = new Stack<>();
        int startIdx = 0;
        for (int idx = 0; idx < string.length(); idx++) {
            char curr = string.charAt(idx);
            if (curr == ' ') {
                int endIdx = idx;
                stack.push(string.substring(startIdx, endIdx));
                startIdx = endIdx;
                while (endIdx < string.length() && curr == ' ') {
                    curr = string.charAt(endIdx);
                    endIdx++;
                }
                stack.push(string.substring(startIdx, endIdx - 1));
                idx = endIdx - 1;
                startIdx = endIdx - 1;
            }
        }
        if (startIdx < string.length()) {
            stack.push(string.substring(startIdx));
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    // O(n) time | O(n) space
    public String reverseWordsInStringMy(String string) {
        // Write your code here.
        if (string.isEmpty() || string.length() == 1) {
            return string;
        }
        int i = 0;
        int j = 1;
        Stack<String> stack = new Stack<>();

        while (j < string.length()) {
            while (j < string.length() && !Character.isWhitespace(string.charAt(j))) {
                j++;
            }
            stack.push(string.substring(i, j));
            i = j;
            while ( j < string.length() && Character.isWhitespace(string.charAt(j))) {
                j++;
            }
            if (j == string.length()) {
                stack.push(string.substring(i, j));
                break;
            }
            stack.push(string.substring(i, j));
            i = j;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        String result = builder.toString();
        return result;
    }

}
