package april_2025;

import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {1,2,2};

        LargestRectangle largestRectangle = new LargestRectangle();
        int result = largestRectangle.largestRectangleArea(heights);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > h) {
                int[] pop = stack.pop();
                int idx = pop[0];
                int height = pop[1];
                int currArea = height * (i - idx);
                maxArea = Math.max(maxArea, currArea);
                start = idx;
            }
            stack.push(new int[] {start, h});
        }
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int idx = pop[0];
            int height = pop[1];
            int currArea = height * (heights.length - idx);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

}
