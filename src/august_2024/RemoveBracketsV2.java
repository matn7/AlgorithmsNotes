package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveBracketsV2 {

    public static void main(String[] args) {
        String str = "))()a)))))bc((((((d)(()))))))))))";

        String result = removeBrackets(str);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String removeBrackets(String str) {
        List<Character> chars = new ArrayList<>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.isEmpty() && c == ')') {
                chars.set(i, ' ');
            } else if (c == ')') {
                stack.pop();
            } else if (c == '(') {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            chars.set(index, ' ');
        }

        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            if (c == ' ') {
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }

}
