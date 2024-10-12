package october_2023;

import java.util.Map;

public class WaterArea {

    public static void main(String[] args) {
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        int result = waterArea(heights);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int waterArea(int[] heights) {
        int[] area = new int[heights.length];

        int leftMax = heights[0];
        for (int i = 1; i < area.length - 1; i++) {
            area[i] = leftMax;
            leftMax = Math.max(leftMax, heights[i]);
        }
        // heights = [0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3]
        // area    = [0, 0, 8, 8, 8, 8, 8, 8, 10, 3, 2, 2, 3, 0]
        //                                        *
        // rightMax = 3
        int rightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            int minHeight = Math.min(rightMax, area[i]); // min(3, 10) = 3
            if (heights[i] < minHeight) { // 1 < 3
                area[i] = minHeight - heights[i];
            } else {
                area[i] = 0;
            }
            rightMax = Math.max(rightMax, heights[i]); // max(3, 0) = 3
        }

        int sum = 0;
        for (int num : area) {
            sum += num;
        }

        return sum;

    }

}
