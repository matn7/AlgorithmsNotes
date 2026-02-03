package february_2026;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 26, 20},
                {23, 30, 34, 60}
        };

        int target = 3;

        Search2DMatrix search2DMatrix = new Search2DMatrix();
        boolean result = search2DMatrix.searchMatrix(matrix, target);
        System.out.println(result);
    }

    // O(log(n * m)) time | O(1) space
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int L = 0;
        int R = rows * cols - 1;

        while (L <= R) {
            int M = (L + R) / 2;
            int row = M / cols;
            int col = M % cols;

            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return false;
    }

    // O(log(m) + log(n)) time | O(1) space
    public boolean searchMatrix2(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int targetRow = -1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][cols]) {
                targetRow = mid;
                if (target == matrix[mid][0] || target == matrix[mid][cols]) {
                    return true;
                }
                break;
            } else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        if (targetRow == -1) {
            return false;
        }
        int[] searchRow = matrix[targetRow];
        int L = 0;
        int R = searchRow.length - 1;

        while (L <= R) {
            int M = (L + R) / 2;
            if (target == searchRow[M]) {
                return true;
            } else if (target > searchRow[M]) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return false;
    }

}
