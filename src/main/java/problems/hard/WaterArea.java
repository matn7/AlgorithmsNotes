package problems.hard;

public class WaterArea {

    public static void main(String[] args) {
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        int result = waterArea(heights);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int waterArea(int[] heights) {
        // Write your code here.
        int[] maxes = new int[heights.length];
        int leftMax = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            maxes[i] = leftMax;
            leftMax = Math.max(leftMax, height);
        }
        int rightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            int minHeight = Math.min(rightMax, maxes[i]);
            if (height < minHeight) {
                maxes[i] = minHeight - height;
            } else {
                maxes[i] = 0;
            }
            rightMax = Math.max(rightMax, height);
        }
        int sum = 0;
        for (int element : maxes) {
            sum += element;
        }
        return sum;
    }

}
