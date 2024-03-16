package january_2024;

public class MaxConnectedColorsInGrid {

    public static void main(String[] args) {
        int[][] colors = {
                {1, 0, 1, 0},
                {0, 1, 1, 1},
                {0, 1, 0, 0},
                {0, 0, 0, 0}
        };

        maxConnectedColors(colors);

    }

    // O(n) time | O(n) space
    public static int maxConnectedColors(int[][] colors) {
        boolean[][] seen = new boolean[colors.length][colors[0].length];

        int max = 0;
        for (int row = 0; row < colors.length; row++) {
            for (int col = 0; col < colors[row].length; col++) {
                if (!seen[row][col]) {
                    int curr = explore(colors, row, col, seen, colors[row][col]);
                    max = Math.max(curr, max);
                }
            }
        }

        return max;
    }

    private static int explore(int[][] colors, int row, int col, boolean[][] seen, int color) {
        if (seen[row][col]) {
            return 0;
        }
        seen[row][col] = true;
        int currColor = colors[row][col];
        if (currColor != color) {
            return 0;
        }
        int count = 1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            if (isValidCoord(colors, row + direction[0], col + direction[1])
                    && colors[row + direction[0]][col + direction[1]] == color) {
                count += explore(colors, row + direction[0], col + direction[1], seen, color);
            }
        }
        return count;
    }

    private static boolean isValidCoord(int[][] colors, int row, int col) {
        return row >= 0 && row <= colors.length - 1 &&  col >= 0 && col <= colors[row].length - 1;
    }


}
