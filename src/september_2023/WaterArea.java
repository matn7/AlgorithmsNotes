package september_2023;

public class WaterArea {

    public static void main(String[] args) {
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        waterArea(heights);
    }

    // O(n) time | O(n) space
    public static int waterArea(int[] heights) {
        // Write your code here.
        //
        //                              #
        //                              #
        //      #                       #
        //      #                       #
        //      #                       #
        //      #           #           #
        //      #           #           #
        //      #           #           #                       #
        //      #           #           #                       #
        //      #           #           #           #   #       #
        //  0   8   0   0   5   0   0   10  0   0   1   1   0   3
        //                                                  *
        if (heights.length == 0) {
            return 0;
        }
        int[] water = new int[heights.length];

        // 0    0   8   8   3   8   8   0   3   3   2   2   3  10       water
        // *
        int leftMax = heights[0]; // 0
        for (int i = 1; i < heights.length - 1; i++) {
            water[i] = leftMax;
            leftMax = Math.max(leftMax, heights[i]); // 10
        }
        int rightMax = heights[heights.length - 1];  // 3
        for (int i = heights.length - 2; i > 0; i--) {
            water[i] = Math.min(water[i] - heights[i], rightMax - heights[i]); // (8 -8, 10 -8)
            if (water[i] <= 0) {
                water[i] = 0;
            }
            rightMax = Math.max(rightMax, heights[i]);
        }
        int sum = 0;
        for (int num : water) {
            sum += num;
        }
        return sum;
    }

}
