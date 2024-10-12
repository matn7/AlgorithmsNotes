package march_2024;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] heights = {5, 9, 2, 4, 3, 7};

        System.out.println(maxArea(heights));
    }

    // O(n) time | O(1) space
    public static int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(heights[l], heights[r]) * (r - l));
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
