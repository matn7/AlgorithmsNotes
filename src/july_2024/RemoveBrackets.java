package july_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveBrackets {

    public static void main(String[] args) {
        String str = "a)bc(d)";

        String result = removeBrackets(str);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String removeBrackets(String str) {
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(str.charAt(i));
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == '(') {
                stack.push(i);
            } else if (res.get(i) == ')' && !stack.isEmpty()) {
                stack.pop();
            } else if (res.get(i) == ')') {
                res.set(i, ' ');
            }
        }
        while (!stack.isEmpty()) {
            res.set(stack.pop(), ' ');
        }
        StringBuilder builder = new StringBuilder();
        for (Character c : res) {
            if (c == ' ') {
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }

}
