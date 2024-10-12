package october_2023;


import java.util.Stack;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String str = "AlgoExpert! is the     best!            ";
                   // best!     the is AlgoExpert!

        System.out.println(reverseWords(str));
    }

    // O(n) time | O(n) space
    public static String reverseWords(String str) {

        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            while (i < str.length() && str.charAt(i) != ' ') {
                builder.append(str.charAt(i));
                i++;
            }
            String word = builder.toString();
            if (builder.length() > 0) {
                stack.push(word);
            }
            builder.setLength(0);
            while (i < str.length() && str.charAt(i) == ' ') {
                builder.append(str.charAt(i));
                i++;
            }
            String whitespace = builder.toString();
            if (builder.length() > 0) {
                stack.push(whitespace);
            }
            builder.setLength(0);
            i--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

}
