package may_2024;


import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveBrackets {

    public static void main(String[] args) {

//        String str = "a)bc(d)";
        String str = "(ab(c)d";
//        String str = "))((";
        String result = removeBrackets(str);

        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static String removeBrackets(String str) {

        // 0 1 2 3 4 5 6
        // a ) b c ( d )
        //             *

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
            Integer currIdx = stack.pop();
            res.set(currIdx, ' ');
        }

        StringBuilder builder = new StringBuilder();
        for (Character character : res) {
            if (character == ' ') {
                continue;
            }
            builder.append(character);
        }


        return builder.toString();
    }

}
