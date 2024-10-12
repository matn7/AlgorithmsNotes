package problems.other;

public class SearchingAMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  3,  5,  8},
                {10, 11, 15, 16},
                {24, 27, 30, 31}
        };

        SearchingAMatrix searchingAMatrix = new SearchingAMatrix();
        boolean result = searchingAMatrix.searchMatrix(matrix, 4);
        System.out.println(result);
    }

    // ********
    // * STAR - G *
    // ********

    // O(log(n)) time | O(1) space
    public boolean searchMatrix(int[][] matrix, int value) {
        if (matrix.length == 0) {
            return false;
        }
        int rows = matrix.length - 1;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols;

        while (low < high) {
            int mid = (low + high) / 2;
            int mid_val = matrix[mid / cols][mid % cols];

            if (mid_val == value) {
                return true;
            }
            if (mid_val < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return false;
    }

    // O(n) time | O(1) space
    public boolean search(int[][] matrix, int num) {
        int row = 0;
        int col = matrix[row].length - 1;
        while (row < matrix.length - 1 && col >= 0) {
            int val = matrix[row][col];
            if (val == num) {
                return true;
            } else if (val > num) { // 11 > 4
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

}
