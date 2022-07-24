package whiteboard;

public class WaterArea2 {

    public static void main(String[] args) {
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        waterArea(heights);
    }

    // O(n) time | O(n) space
    public static int waterArea(int[] heights) {
        // Write your code here.
        if (heights.length == 0) {
            return 0;
        }
        int[] waters = new int[heights.length];
        int leftMax = heights[0];

        for (int i = 0; i < heights.length; i++) {
            leftMax = Math.max(leftMax, heights[i]);
            waters[i] = leftMax;
        }

        int rightMax = heights[heights.length - 1];
        for (int i = heights.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, heights[i]);
            waters[i] = Math.min(rightMax - heights[i], waters[i] - heights[i]);
        }
        int sum = 0;
        for (int element : waters) {
            sum += element;
        }

        return sum;
    }

}
