package august_2024;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 4, 8},
                {10, 11, 15, 16},
                {24, 27, 30, 31}
        };

        int value = 10;

        System.out.println(searchMatrix(matrix, value));

        System.out.println(searchMatrixV2(matrix, value));
    }

    public static boolean searchMatrixV2(int[][] matrix, int value) {
        //   0  1  2  3     4   5   6   7     8   9  10  11
        // [[1, 3, 4, 8], [10, 11, 15, 16], [24, 27, 30, 31]]
        //            s     e
        //            m
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols;

        while (start < end) {
            int midIdx = (start + end) / 2;
            // 2 / 4 = 0
            // 2 % 4 = 2
            int midVal = matrix[midIdx / cols][midIdx % cols];
            if (midVal == value) {
                return true;
            }
            if (midVal > value) {
                end = midIdx - 1;
            } else {
                start = midIdx + 1;
            }
        }
        return false;
    }

    // O(n) time | O(n) space
    public static boolean searchMatrix(int[][] matrix, int value) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == value) {
                return true;
            }
            if (matrix[row][col] < value) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

}
