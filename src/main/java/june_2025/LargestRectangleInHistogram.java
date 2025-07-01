package june_2025;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {2, 4};

        LargestRectangleInHistogram rectangle = new LargestRectangleInHistogram();
        int result = rectangle.largestRectangleArea(heights);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int idx = i;
            int h = heights[i];
            while (!stack.isEmpty() && stack.peek()[1] > h) {
                int[] curr = stack.pop();
                int currArea = (i - curr[0]) * curr[1];
                maxArea = Math.max(maxArea, currArea);
                idx = curr[0];
            }
            stack.add(new int[] {idx, h});
        }
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int currArea = (heights.length - curr[0]) * curr[1];
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

}
