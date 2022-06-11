package hard;

public class WaterAreaREPEAT {

    public static void main(String[] args) {
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        waterArea(heights);
    }
    //               #
    //               #
    //   #-----------#
    //   #           #
    //   #     3     #
    //   #     #     #
    //   #     #     #
    //   #     #     #-----------#
    //   #     #     #     2 2   #
    //   # 8 8 # 8 8 # 3 3 # # 3 #
    // -+-+-+-+-+-+-+-+-+-+-+-+-+-
    // 0 8 0 0 5 0 010 0 0 1 1 0 3


    // O(n) time | O(n) space
    // OK - repeated 03/02/2022
    public static int waterArea(int[] heights) {
        // Write your code here.
        //                                                        i
        // heights=[0, 8, 0, 0, 5, 0, 0, 10,  0,  0,  1,  1,  0,  3]
        // maxes = [0, 0, 8, 8, 8, 8, 8,  8, 10, 10, 10, 10, 10, 10]    <-- max from left
        int[] maxes = new int[heights.length];
        int leftMax = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i]; // 3
            maxes[i] = leftMax; // 10
            leftMax = Math.max(leftMax, height); // max(10, 3) = 10
        }
        //          i
        // heights=[0, 8, 0, 0, 5, 0, 0, 10,  0,  0,  1,  1,  0,  3]
        // maxes = [0, 0, 8, 8, 3, 8, 8,  0,  3,  3,  2,  2,  3,  0]
        int rightMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i]; // 0
            int minHeight = Math.min(rightMax, maxes[i]); // min(10, 0) = 0
            if (height < minHeight) { // 8 < 0
                maxes[i] = minHeight - height; // 8 - 5
            } else {
                maxes[i] = 0;
            }
            rightMax = Math.max(rightMax, height); // max(10, 8) = 10
        }
        // maxes = [0, 0, 8, 8, 3, 8, 8, 0, 3, 3, 2, 2, 3, 0]
        int result = 0;
        for (int element : maxes) {
            result += element;
        }
        return result;
    }

}
