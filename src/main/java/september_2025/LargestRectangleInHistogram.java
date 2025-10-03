package september_2025;

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1};

        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int result = largestRectangleInHistogram.largestRectangleArea(heights);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<int[]> stack = new ArrayDeque<>(); // [height, idx]

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            int idx = i;

            while (!stack.isEmpty() && stack.getFirst()[0] > curr) {
                int[] element = stack.removeFirst(); // [height, idx]
                maxArea = Math.max(maxArea, element[0] * (i - element[1]));
                idx = element[1];
            }

            stack.addFirst(new int[] {curr, idx});
        }

        while (!stack.isEmpty()) {
            int[] element = stack.removeFirst();
            maxArea = Math.max(maxArea, element[0] * (heights.length - element[1]));
        }

        return maxArea;
    }

}
