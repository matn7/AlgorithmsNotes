package october_2023;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {2, 5, -3, -4, 6, 7, 2};

        nextGreaterElement(arr);
    }

    // O(n) time | O(n) space
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int idx = 2 * (arr.length - 1); idx >= 0; idx--) {
            int circularIdx = idx % arr.length;
            while (stack.size() > 0) {
                if (stack.peek() <= arr[circularIdx]) {
                    stack.pop();
                } else {
                    result[circularIdx] = stack.peek();
                    break;
                }
            }
            stack.push(arr[circularIdx]);
        }

        return result;
    }

    // O(n^2) time | O(n) space
    public static int[] nextGreaterElement2(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        // [5, 6, 6, 6, 7, 0, 0]
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int other = arr[j];
                if (other > current) {
                    result[i] = other;
                    break;
                }
            }
        }
        int current = arr[arr.length -1];
        for (int i = 0; i < arr.length; i++) {
            int other = result[i];
            if (current < other) {
                result[arr.length - 1] = other;
                break;
            }
        }
        return result;
    }

}
