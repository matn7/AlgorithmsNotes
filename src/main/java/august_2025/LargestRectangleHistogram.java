package august_2025;


import java.util.Stack;

public class LargestRectangleHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        int result = largestRectangleHistogram.largestRectangleArea(heights);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            int idx = i;
            while (!stack.isEmpty() && stack.peek()[0] >= curr) {
                int[] pop = stack.pop();
                int area = pop[0] * (i - pop[1]);
                maxArea = Math.max(maxArea, area);
                idx = pop[1];
            }
            stack.push(new int[] {curr, idx});
        }

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int area = pop[0] * (heights.length - pop[1]);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

}
