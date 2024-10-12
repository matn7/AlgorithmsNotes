package september_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {2, 1, 2};

        LargestRectangle largestRectangle = new LargestRectangle();
        int result = largestRectangle.largestRectangleArea(heights);
        System.out.println(result);

        int result1 = largestRectangle.largestRectangleAreaV3(heights);
        System.out.println(result1);
    }


    // O(n^2) time | O(1) space
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = 1;
            int left = i - 1;
            while (left >= 0 && heights[left] >= height) {
                width++;
                left--;
            }
            int right = i + 1;
            while (right < heights.length && heights[right] >= height) {
                width++;
                right++;
            }
            int currArea = height * width;
            max = Math.max(max, currArea);

        }

        return max;
    }

    // O(n) time | O(n) space
    public int largestRectangleAreaV2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        List<Integer> heightsArr = new ArrayList<>();
        for (int height : heights) {
            heightsArr.add(height);
        }
        heightsArr.add(0);
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(0);

        for (int i = 1; i < heightsArr.size(); i++) {
            int height = heightsArr.get(i);
            while (!stack.isEmpty() && heightsArr.get(stack.peek()) > height) {
                Integer index = stack.pop();
                int width = i - index;
                int currHeight = heightsArr.get(index);
                int currArea = currHeight * width;
                max = Math.max(max, currArea);
            }
            stack.push(i);
        }

        return max;
    }

    // leetcode 84

    // O(n) time | O(n) space
    public int largestRectangleAreaV3(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for (int idx = 0; idx < heights.length; idx++) {
            int i = idx;
            int h = heights[idx];
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
