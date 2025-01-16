package november_2024;

import java.util.Stack;

public class LongestRectangleArea {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
//        int[] heights = {2, 4};

        LongestRectangleArea longestRectangleArea = new LongestRectangleArea();
        int result = longestRectangleArea.largestRectangleArea(heights);
        System.out.println(result);
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= height) {
                int idx = stack.pop();
                int h = heights[idx];
                int w = i - idx;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int h = heights[idx];
            int w = heights.length - idx;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }

}
