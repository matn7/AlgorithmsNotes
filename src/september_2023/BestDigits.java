package september_2023;

import java.util.Stack;

public class BestDigits {

    public static void main(String[] args) {
        String number = "462839";
        int numDigits = 2;

        BestDigits bestDigits = new BestDigits();
        bestDigits.bestDigits(number, numDigits);
    }

    // O(n) time | O(n) space
    public String bestDigits(String number, int numDigits) {
        // Write your code here.
        // 4 6 2 8 3 9
        //       *
        // stack = [6]
        // numDigits = 1
        Stack<Integer> stack = new Stack<>();
        for (char c : number.toCharArray()) {
            int digit = (int) c - (int) '0';
            while (numDigits > 0 && !stack.isEmpty() && digit > stack.peek()) {
                stack.pop();
                numDigits--;
            }
            stack.push(digit);
        }
        while (numDigits > 0) {
            stack.pop();
            numDigits--;
        }
        Stack<Integer> reversed = new Stack<>();
        while (!stack.isEmpty()) {
            reversed.push(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        while (!reversed.isEmpty()) {
            result.append(reversed.pop());
        }
        return result.toString();
    }
}
