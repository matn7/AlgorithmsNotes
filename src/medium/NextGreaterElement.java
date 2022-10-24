package medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] array = {2, 5, -3, -4, 6, 7, 2};

        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        nextGreaterElement.nextGreaterElement(array);
    }

    // O(n) time | O(n) space
    public int[] nextGreaterElement(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int idx = array.length * 2 - 1; idx >= 0; idx--) {
            int circularIdx = idx % array.length;

            while (!stack.isEmpty()) {
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

    // O(n) time | O(n) space
    public int[] nextGreaterElement2(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int idx = 0; idx < array.length * 2; idx++) {
            int circularIdx = idx % array.length;

            while (!stack.isEmpty() && array[stack.peek()] < array[circularIdx]) {
                Integer top = stack.pop();
                result[top] = array[circularIdx];
            }

            stack.add(circularIdx);
        }
        return result;
    }

}
