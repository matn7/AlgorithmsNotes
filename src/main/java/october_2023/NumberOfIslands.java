package october_2023;

public class NumberOfIslands {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0}
        };

        System.out.println(numberOfIslands(matrix));

    }

    // O(n*m) time | O(n) space
    public static int numberOfIslands(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    count++;
                    sinkIsland(matrix, row, col);
                }
            }
        }

        return count;
    }

    private static void sinkIsland(int[][] matrix, int row, int col) {

        matrix[row][col] = 1;
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            if (isValidPosition(matrix, row, col, direction)) {
                if (matrix[row + direction[0]][col + direction[1]] == 0) {
                    sinkIsland(matrix, row + direction[0], col + direction[1]);
                }
            }
        }
    }

    private static boolean isValidPosition(int[][] matrix, int row, int col, int[] direction) {
        return row + direction[0] >= 0 && row + direction[0] <= (matrix.length - 1)
                && col + direction[1] >= 0 && col + direction[1] <= (matrix[row].length - 1);
    }

}
