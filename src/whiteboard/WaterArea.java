package whiteboard;

public class WaterArea {

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

    // MOST OPTIMAL - but no dynamic programming techniques used
    // O(n) time | O(1) space
    public static int waterAreaOptimal(int[] heights) {
        // Write your code here.
        if (heights.length < 2) {
            return 0;
        }
        int waterArea = 0;
        int left = 0;
        int right = heights.length - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];
        while (left <= right) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, heights[left]);
                waterArea += (leftMax - heights[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, heights[right]);
                waterArea += (rightMax - heights[right]);
                right--;
            }
        }
        return waterArea;
    }

    // O(n) time | O(n) space
    public static int waterArea2(int[] heights) {
        // Write your code here.
        if (heights.length == 0) {
            return 0;
        }
        int leftMax = heights[0];
        int[] water = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            leftMax = Math.max(leftMax, heights[i]);
            water[i] = leftMax - heights[i];
        }
        int rightMax = heights[heights.length - 1];
        for (int i = heights.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, heights[i]);
            water[i] = Math.min(water[i], rightMax - heights[i]);
        }
        int sum = 0;
        for (int w : water) {
            sum += w;
        }
        return sum;
    }

}
