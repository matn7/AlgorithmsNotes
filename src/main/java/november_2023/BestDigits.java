package november_2023;


import java.util.Stack;

public class BestDigits {

    public static void main(String[] args) {
        String number = "462839";
        int nums = 2;

        System.out.print(bestDigits(number, nums));
    }

    // O(n) time | O(n) space
    public static String bestDigits(String number, int nums) {
        Stack<Integer> stack = new Stack<>();
        int digits = nums;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            int val = c - '0';
            while (digits > 0 && !stack.isEmpty() && stack.peek() < val) {
                stack.pop();
                digits--;
            }
            stack.push(val);
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        String string = builder.reverse().toString();

        return string;

    }

}
