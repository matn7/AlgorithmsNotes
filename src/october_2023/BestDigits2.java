package october_2023;

import java.awt.desktop.PreferencesEvent;
import java.util.Stack;

public class BestDigits2 {

    public static void main(String[] args) {
        String num = "462839";
        int digits = 2;

        String result = bestDigits(num, digits);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String bestDigits(String num, int digits) {
        // 462839
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int val = c - '0';
            while (!stack.isEmpty() && stack.peek() < val && digits > 0) {
                stack.pop();
                digits--;
            }
            stack.push(val);
        }

        while (digits > 0) {
            stack.pop();
            digits--;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        builder.reverse();
        return builder.toString();
    }

}
