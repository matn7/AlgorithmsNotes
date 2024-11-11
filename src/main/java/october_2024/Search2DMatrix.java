package october_2024;

public class Search2DMatrix {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        };

        int[][] matrix = {
                {1, 3}
        };

        Search2DMatrix search2DMatrix = new Search2DMatrix();
        boolean result = search2DMatrix.searchMatrix(matrix, 3);
        System.out.println(result);
    }

    // O(log(m + n) time | O(1) space
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bot = rows - 1;

        // Binary search to find the correct row
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][cols - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                // Target is within the range of the current row
                break;
            }
        }

        // If we did not find a valid row, return false
        if (top > bot) {
            return false;
        }

        int row = (top + bot) / 2;
        int l = 0;
        int r = cols - 1;

        // Binary search to find the target within the row
        while (l <= r) {
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true; // Target found
            }
        }

        return false; // Target not found
    }

}


