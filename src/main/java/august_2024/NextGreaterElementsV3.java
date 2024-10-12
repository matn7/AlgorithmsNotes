package august_2024;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementsV3 {

    public static void main(String[] args) {
        int[] arr = {2, 5, -3, -4, 6, 7, 2};

        nextGreaterElement(arr);
    }

    // O(n) time | O(n) space
    public static int[] nextGreaterElement(int[] arr) {

        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * arr.length - 1; i >= 0; i--) {
            int idx = i % arr.length;
            int num = arr[idx];
            while (!stack.isEmpty()) {
                if (num >= stack.peek()) { // 6 >= 7
                    stack.pop();
                } else {
                    Integer peek = stack.peek();
                    result[idx] = peek;
                    break;
                }
            }
            stack.push(num);
        }
        return result;

    }

}
