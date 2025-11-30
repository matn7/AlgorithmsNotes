package november_2025;

import java.util.ArrayDeque;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String s = "azxxzy";

        RemoveAllAdjacentDuplicatesInString removeAllAdjacentDuplicatesInString
                = new RemoveAllAdjacentDuplicatesInString();

        String result = removeAllAdjacentDuplicatesInString.removeDuplicates(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public String removeDuplicates(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char curr : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.addLast(curr);
            } else {
                if (stack.getLast() == curr) {
                    stack.removeLast();
                } else {
                    stack.addLast(curr);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.removeFirst());
        }
        return builder.toString();
    }

}
