package july_2024;

public class WaterArea {

    public static void main(String[] args) {
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        int result = waterArea(heights);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int waterArea(int[] heights) {
        if (heights.length <= 2) {
            return 0;
        }
        // heights = [0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3]
        int[] left = new int[heights.length];
        int leftMax = heights[0];
        for (int i = 0; i < heights.length; i++) {
            left[i] = leftMax;
            leftMax = Math.max(leftMax, heights[i]);
        }
        // left = [0, 0, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10]
        int[] right = new int[heights.length];
        int rightMax = heights[heights.length - 1];
        for (int i = heights.length - 1; i >= 0; i--) {
            int minValue = Math.min(left[i], rightMax);
            int value = minValue - heights[i];
            if (value < 0) {
                value = 0;
            }
            right[i] = value;
            rightMax = Math.max(rightMax, heights[i]);
        }
        // right = [0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3]
        int sum = 0;
        for (int num : right) {
            sum += num;
        }

        return sum;
    }

}
