package july_2024;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {2, 5, -3, -4, 6, 7, 2};

        int[] result = nextGreaterElement(arr);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int idx = 2 * (array.length) - 1; idx >= 0; idx--) {
            int circularIdx = idx % array.length;
            while (stack.size() > 0) {
                if (stack.peek() <= array[circularIdx]) {
                    stack.pop();
                } else {
                    result[circularIdx] = stack.peek();
                    break;
                }
            }
            stack.add(array[circularIdx]);
        }
        return result;
    }

}
