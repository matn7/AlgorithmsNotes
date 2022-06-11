package whiteboard;

public class WaterAreaNOT {

    public static void main(String[] args) {
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        waterArea(heights);
    }

    public static int waterArea(int[] heights) {
        // Write your code here.
        int[] waterArray = new int[heights.length];
        waterArray[0] = 0;

        for (int i = 1; i < heights.length; i++) {
            waterArray[i] = Math.max(waterArray[i - 1], heights[i]);
        }

        int currMax = heights[heights.length - 1];
        waterArray[waterArray.length - 1] = 0;
        for (int j = heights.length - 2; j >= 0; j--) {
            currMax = Math.max(waterArray[j], waterArray[j + 1]);
            waterArray[j] = Math.min(waterArray[j], currMax - heights[j]);
            System.out.println();
        }

        return -1;
    }

}
