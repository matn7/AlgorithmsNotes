package january_2025;

import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int[] heights = {1, 2, 2};

        LargestRectangle largestRectangle = new LargestRectangle();
        int result = largestRectangle.largestRectangleArea(heights);
        System.out.println(result);
    }

    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > h) {
                int[] pop = stack.pop();
                int index = pop[0];
                int height = pop[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[] {start, h});
        }
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int i = pop[0];
            int h = pop[1];
            maxArea = Math.max(maxArea, h * (heights.length - i));
        }
        return maxArea;
    }

}
