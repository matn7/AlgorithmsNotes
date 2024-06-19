package may_2024;

public class NumberOfIslands {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 1, 1, 1, 0},
//                {1, 1, 0, 1, 0},
//                {1, 1, 0, 0, 1},
//                {0, 0, 0, 1, 1}
//        };

//        int[][] matrix = {
//                {1, 0, 1, 1, 0}
//        };

        int[][] matrix = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 1, 1, 1, 0},
            {1, 0, 1, 0, 1}
        };

//        int[][] matrix = {{},{}};

        int result = numberOfIslands(matrix);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int numberOfIslands(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] seen = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (isLand(row, col, matrix) && !seen[row][col]) {
                    count++;
                    explore(row, col, matrix, seen);
                }
            }
        }
        return count;
    }

    private static void explore(int row, int col, int[][] matrix, boolean[][] seen) {

        seen[row][col] = true;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidPos(newRow, newCol, matrix) && !seen[newRow][newCol] && isLand(newRow, newCol, matrix)) {
                explore(newRow, newCol, matrix, seen);
            }
        }
    }

    private static boolean isLand(int row, int col, int[][] matrix) {
        return matrix[row][col] == 1;
    }

    private static boolean isValidPos(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }

}
