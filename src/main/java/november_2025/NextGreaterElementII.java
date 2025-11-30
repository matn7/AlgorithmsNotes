package november_2025;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};

        NextGreaterElementII nextGreaterElementII = new NextGreaterElementII();
        int[] result = nextGreaterElementII.nextGreaterElements(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int idx = i % nums.length;
            int num = nums[idx];

            while (!stack.isEmpty() && num >= stack.getLast()) {
                stack.removeLast();
            }
            res[idx] = stack.isEmpty() ? -1 : stack.getLast();
            stack.addLast(num);
        }
        return res;
    }

}
