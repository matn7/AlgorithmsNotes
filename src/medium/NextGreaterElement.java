package medium;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] array = {2, 5, -3, -4, 6, 7, 2};
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        nextGreaterElement.nextGreaterElement2(array);
    }

    // O(n) time | O(n) space
    public int[] nextGreaterElement(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int idx = 0; idx < 2 * array.length; idx++) {
            int circularIdx = idx % array.length;

            while (stack.size() > 0 && array[stack.peek()] < array[circularIdx]) {
                int top = stack.pop();
                result[top] = array[circularIdx];
            }

            stack.add(circularIdx);
        }

        return result;
    }

    // O(n) time | O(n) space
    public int[] nextGreaterElement2(int[] array) {
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
