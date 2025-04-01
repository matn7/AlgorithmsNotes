package january_2025;

import java.util.Stack;

public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3, 1, 0, 1, 1, 1, 1, 1, 1, 1};

        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int result = largestRectangleArea.largestRectangleArea(heights);
        System.out.println(result);
    }

    public int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int current = heights[i];
            int start = i;
            while (!stack.isEmpty() && current <= stack.peek()[0]) {
                int[] calc = stack.pop();
                int currMax = calc[0] * (i - calc[1]);
                maxArea = Math.max(maxArea, currMax);
                start = calc[1];
            }
            stack.push(new int[] {current, start});
        }

        while (!stack.isEmpty()) {
            int[] calc = stack.pop();
            int currMax = calc[0] * (heights.length - calc[1]);
            maxArea = Math.max(maxArea, currMax);
        }

        return maxArea;
    }

}
