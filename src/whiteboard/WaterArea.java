package whiteboard;

public class WaterArea {

    public static void main(String[] args) {
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        waterArea(heights);
    }

    // O(n) time | O(n) space
    // #2: 11/07/2022
    public static int waterArea(int[] heights) {
        // Write your code here.
        if (heights.length == 0) {
            return 0;
        }
        int[] waters = new int[heights.length];

        int leftMax = 0;
        for (int idx = 1; idx < heights.length; idx++) {
            int prevVal = heights[idx - 1];
            leftMax = Math.max(leftMax, prevVal);
            waters[idx] = leftMax;
        }

        int rightMax = 0;
        waters[heights.length - 1] = 0;
        for (int idx = heights.length - 2; idx >= 0; idx--) {
            int nextVal = heights[idx + 1];
            rightMax = Math.min(Math.max(rightMax, nextVal), waters[idx]);
            int pourWater = rightMax - heights[idx];
            if (pourWater < 0) {
                waters[idx] = 0;
            } else {
                waters[idx] = rightMax - heights[idx];
            }
        }

        int sum = 0;
        for (int element : waters) {
            sum += element;
        }

        return sum;
    }

}
