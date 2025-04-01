package march_2025;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {

    public static void main(String[] args) {
        int[] nums = {2, 5, -3, -4, 6, 7, 2};

        NextGreaterElements nextGreaterElements = new NextGreaterElements();
        int[] result = nextGreaterElements.nextGreaterElements(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int idx = i % nums.length;
            int num = nums[idx];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            result[idx] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }

        return result;
    }

}
