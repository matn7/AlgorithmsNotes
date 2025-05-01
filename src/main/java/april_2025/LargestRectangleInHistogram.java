package april_2025;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int result = largestRectangleInHistogram.largestRectangleArea(heights);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int num = heights[i];
            int currIdx = i;
            while (!stack.isEmpty() && stack.peek()[1] >= num) {
                int[] top = stack.pop();
                int currVal = top[1];
                currIdx = top[0];
                max = Math.max(max, currVal * (i - currIdx));
            }
            stack.push(new int[] {currIdx, num});
        }

        int len = heights.length;
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int currVal = top[1];
            int currIdx = top[0];
            max = Math.max(max, currVal * (len - currIdx));
        }

        return max;
    }

}
