package november_2024;

public class GridGame {

    public long gridGame(int[][] grid) {
        int N = grid[0].length;

        // Create long[] arrays instead of int[]
        long[] preRow1 = new long[grid[0].length];
        long[] preRow2 = new long[grid[1].length];

        // Manually copy values from int[] to long[]
        for (int i = 0; i < N; i++) {
            preRow1[i] = (long) grid[0][i];  // Convert each int to long
            preRow2[i] = (long) grid[1][i];  // Convert each int to long
        }

        // Calculate the prefix sums for both rows
        for (int i = 1; i < N; i++) {
            preRow1[i] = preRow1[i] + preRow1[i - 1];
            preRow2[i] = preRow2[i] + preRow2[i - 1];
        }

        // Initialize result as Long.MAX_VALUE
        long res = Long.MAX_VALUE;

        // Iterate through each index to calculate the result
        for (int i = 0; i < N; i++) {
            long top = preRow1[preRow1.length - 1] - preRow1[i];
            long bottom = i > 0 ? preRow2[i - 1] : 0;

            // Get the maximum of top and bottom
            long second = Math.max(top, bottom);

            // Minimize the result
            res = Math.min(res, second);
        }

        return res;
    }

}
