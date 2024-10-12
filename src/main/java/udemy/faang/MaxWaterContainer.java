package udemy.faang;

public class MaxWaterContainer {

    public static void main(String[] args) {
        int[] height = {4, 8, 11, 2, 3, 9};

        MaxWaterContainer maxWaterContainer = new MaxWaterContainer();
        maxWaterContainer.maxAreaOptimal(height);
    }

    // O(n^2) time | O(1) space
    public int maxArea(int[] heights) {
        int maxArea = 0;
        for (int p1 = 0; p1 < heights.length; p1++) {
            for (int p2 = p1 + 1; p2 < heights.length; p2++) {
                int height = Math.min(heights[p1], heights[p2]);
                int width = p2 - p1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // O(n) time | O(1) space
    public int maxAreaOptimal(int[] height) {
        int maxArea = 0;
        int a = 0;
        int b = height.length - 1;
        while (a < b) {
            int aVal = height[a];
            int bVal = height[b];
            int currHeight = Math.min(aVal, bVal);
            int width = b - a;
            int area = currHeight * width;
            maxArea = Math.max(maxArea, area);
            if (aVal < bVal) {
                a++;
            } else {
                b--;
            }
        }
        return maxArea;
    }

}
