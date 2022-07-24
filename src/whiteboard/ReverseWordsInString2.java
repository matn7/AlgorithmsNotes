package whiteboard;

import java.util.Stack;

public class ReverseWordsInString2 {

    public static void main(String[] args) {
        String string = "AlgoExpert is the best!";
        ReverseWordsInString2 rw2 = new ReverseWordsInString2();
        rw2.reverseWordsInString(string);
    }

    // O(n) time | O(n) space
    public String reverseWordsInString(String string) {
        // Write your code here.
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char curr = string.charAt(i);
            StringBuilder element = new StringBuilder();
            while (curr != ' ' && i < string.length() - 1) {
                element.append(curr);
                i++;
                curr = string.charAt(i);
            }
            if (i == string.length() - 1) {
                element.append(curr);
                stack.add(element.toString());
                break;
            }
            stack.add(element.toString());
            element.setLength(0);

            while (curr == ' ' && i < string.length() - 1) {
                element.append(curr);
                i++;
                curr = string.charAt(i);
            }
            stack.add(element.toString());
            i--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        String string1 = result.toString();
        return string1;
    }

}
