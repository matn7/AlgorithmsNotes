package medium;

import java.util.LinkedList;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = reverseWordsInString("AlgoExpert is the best!");
//        String s = reverseWordsInString("whitespaces    4");
        System.out.println(s);
    }

    public static String reverseWordsInString(String string) {
        // Write your code here.
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isWhitespace(string.charAt(i))) {
                while (i < string.length() && !Character.isWhitespace(string.charAt(i))) {
                    word.append(string.charAt(i));
                    i++;
                }
                stack.push(word.toString());
                word.setLength(0);
                i--;
            } else {
                while (i < string.length() && Character.isWhitespace(string.charAt(i))) {
                    word.append(' ');
                    i++;
                }
                stack.push(word.toString());
                word.setLength(0);
                i--;
            }
        }

        StringBuilder reversed = new StringBuilder();
        for (String element : stack) {
            if (element.equals("")) {
                reversed.append(" ");
            }
            reversed.append(element);
        }
        return reversed.toString();
    }
}
