package march_2025;

import java.util.Stack;

public class LargestRectangleArea {

    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
//        int[] heights = {1, 2, 2};

        int[] heights = {5,4,1,2};

        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int result = largestRectangleArea.largestRectangleArea(heights);
        System.out.println(result);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int start = i;
            while (!stack.isEmpty() && stack.peek()[0] > h) {
                int[] top = stack.pop();
                int area = top[0] * (i - top[1]);
                max = Math.max(max, area);
                start = top[1];
            }
            stack.push(new int[] {h, start});
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int area = top[0] * (heights.length - top[1]);
            max = Math.max(max, area);
        }

        return max;
    }

}
