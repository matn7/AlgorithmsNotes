package may_2025;

import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3, 1, 1, 1, 1, 1, 1, 2, 1};

        LargestRectangle largestRectangle = new LargestRectangle();
        int result = largestRectangle.largestRectangleArea(heights);
        System.out.println(result);
    }

    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int j = i;
            while (!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                int[] pop = stack.pop();
                j = pop[1];
                max = Math.max(max, (i - pop[1]) * pop[0]);
            }
            stack.push(new int[] {heights[i], j});
        }
        int idx = heights.length;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            max = Math.max(max, (idx - pop[1]) * pop[0]);
        }
        return max;
    }

}
