package june_2025;

import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3,1,1,1,1,1,1};
        LargestRectangle largestRectangle = new LargestRectangle();
        int result = largestRectangle.largestRectangleArea(heights);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int largestRectangleArea(int[] heights) {
        if (heights.length <= 1) {
            return heights.length;
        }
        int maxRect = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {0, 0});
        for (int i = 1; i < heights.length; i++) {
            int idx = i;
            while (!stack.isEmpty() && heights[stack.peek()[1]] >= heights[i]) {
                int[] current = stack.pop();
                int currRect = (i - current[0]) * heights[current[1]];
                maxRect = Math.max(maxRect, currRect);
                idx = current[0];
            }
            stack.push(new int[] {idx, i});
        }
        int len = heights.length;
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int currRect = (len - current[0]) * heights[current[1]];
            maxRect = Math.max(maxRect, currRect);
        }
        return maxRect;
    }

}
