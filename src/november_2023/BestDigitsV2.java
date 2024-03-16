package november_2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BestDigitsV2 {

    public static void main(String[] args) {
        String str = "462839";

        System.out.println(bestDigits(str, 2));
    }

    // O(n) time | O(n) space
    public static String bestDigits(String str, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int val = c - '0';
            while (!stack.isEmpty() && stack.peek() < val && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(val);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        List<Integer> arr = new ArrayList<>();
        while (!stack.isEmpty()) {
            arr.add(stack.pop());
        }
        Collections.reverse(arr);
        StringBuilder result = new StringBuilder();
        for (Integer num : arr) {
            result.append(num);
        }
        return result.toString();
    }

}
