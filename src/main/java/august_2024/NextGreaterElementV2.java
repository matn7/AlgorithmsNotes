package august_2024;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementV2 {

    public static void main(String[] args) {
        int[] curr = {2, 5, -3, -4, 6, 7, 2};

        int[] result = nextGreaterElement(curr);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int[] nextGreaterElement(int[] curr) {
        int[] result = new int[curr.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int idx = (2*curr.length) - 1; idx >= 0; idx--) {
            int circularIdx = idx % curr.length;
            int value = curr[circularIdx]; // 13 % 7
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (peek > value) {
                    result[circularIdx] = peek;
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(value);
        }

        return result;
    }

}
