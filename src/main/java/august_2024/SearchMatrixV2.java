package august_2024;

public class SearchMatrixV2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 8},
                {10, 11, 14, 16},
                {24, 27, 30, 31}
        };

        boolean result = searchMatrix(matrix, 10);
        System.out.println(result);

        System.out.println(searchMatrixV2(matrix, 10));
    }

    // O(log(n)) time | O(1) space
    public static boolean searchMatrixV2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //   0  1  2  3     4   5   6   7     8   9  10  11
        // [[1, 3, 5, 8], [10, 11, 14, 16], [24, 27, 30, 31]]
        //   s                  m                         e
        int start = 0;
        int end = rows * cols;

        while (start < end) {
            int mid = (start + end) / 2;
            int searchRow = mid / cols; // 5 / 4 = 1
            int searchCol = mid % cols; // 5 % 4 = 1
            if (matrix[searchRow][searchCol] == target) {
                return true;
            } else if (matrix[searchRow][searchCol] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    // O(n) time | O(1) space
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[row].length - 1;

        while (row <= matrix.length - 1 && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

}
