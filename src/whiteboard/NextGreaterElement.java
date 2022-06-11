package whiteboard;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] array = {2, 5, -3, -4, 6, 7, 2};
        NextGreaterElement next = new NextGreaterElement();
        next.nextGreaterElement(array);
    }

    // O(n) time | O(n) space
    public int[] nextGreaterElement(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();

        for (int idx = 2*(array.length - 1); idx >= 0; idx--) {
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
