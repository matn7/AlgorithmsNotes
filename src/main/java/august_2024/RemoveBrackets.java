package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveBrackets {

    public static void main(String[] args) {
        String str = ")))(((a)bc(d)))))))(((";

        String result = removeBrackets(str);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String removeBrackets(String str) {
        //    0    1    2    3    4    5    6    7    8    9    10   11   12
        // [ 'a', ' ', 'b', 'c', '(', 'd', ')', ' ', ' ', ' ', '(', '(', '(']
        //                                                      *

        List<Character> chars = new ArrayList<>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }

        Stack<Integer> openingStack = new Stack<>(); // [10, 11, 12]

        for (int i = 0; i < chars.size(); i++) {
            char c = chars.get(i);
            if (c == '(') {
                openingStack.push(i);
            } else if (c == ')' && !openingStack.isEmpty()) {
                openingStack.pop();
            } else if (c == ')') {
                chars.set(i, ' ');
            }
        }

        while (!openingStack.isEmpty()) {
            int idx = openingStack.pop();
            chars.remove(idx);
        }

        StringBuilder builder = new StringBuilder();

        for (Character c : chars) {
            if (c == ' ') {
                continue;
            }
            builder.append(c);
        }

        return builder.toString();
    }

}
