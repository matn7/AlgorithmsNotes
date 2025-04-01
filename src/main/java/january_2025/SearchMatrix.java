package january_2025;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        SearchMatrix searchMatrix = new SearchMatrix();
        searchMatrix.searchMatrix(matrix, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int curr = matrix[mid / cols][mid % cols];
            if (curr == target) {
                return true;
            } else if (target > curr) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrixLin(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[row].length - 1;

        while (row <= matrix.length - 1 && col >= 0) {
            int curr = matrix[row][col];
            if (curr == target) {
                return true;
            } else if (curr > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

}
