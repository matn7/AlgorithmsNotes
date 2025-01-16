package november_2024;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        SearchMatrix searchMatrix = new SearchMatrix();
        boolean result = searchMatrix.searchMatrix(matrix, 7);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0;
        int r = rows * cols - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int rIdx = mid / cols; // each row has cols elements
            int cIdx = mid % cols; // tels where position is in cols
            if (matrix[rIdx][cIdx] == target) {
                return true;
            } else if (matrix[rIdx][cIdx] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[row].length - 1;

        while (row < matrix.length && col >= 0) {
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
