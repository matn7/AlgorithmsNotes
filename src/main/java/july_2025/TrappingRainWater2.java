package july_2025;

import java.util.Enumeration;

public class TrappingRainWater2 {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        TrappingRainWater2 trappingRainWater2 = new TrappingRainWater2();
        int result = trappingRainWater2.trap(height);
        System.out.println(result);
    }

    // Intuition:
    // - how to determine water trap.
    // - on border 0
    // - couple of loop through input, l to r, r to l, and to calc sum
    // Approach:
    // - start from left, max height from left
    // - start from right, max height from right
    // - diff between left and right and take height into account
    // Complexity:
    // O(n) time | O(n) space
    // Code:

    //                *
    // heights    = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]

    // water      = [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
    // water2     = [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 1]

    // min(w1,w2) = [0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0] - height[i] < 0
    // if  min(w1,w2) - height[i] < 0 -> 0
    // leftMax = 1

    public int trap(int[] height) {
        int[] water = new int[height.length];
        int leftMax = height[0];
        for (int i = 0; i < height.length; i++) {
            water[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        int sum = 0;
        int rightMax = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            water[i] = Math.min(water[i], rightMax);
            rightMax = Math.max(rightMax, height[i]);
            int h = water[i] - height[i];
            if (h < 0) {
                water[i] = 0;
            } else {
                water[i] = h;
            }
            sum += water[i];
        }

        return sum;
    }

}
