package december_2025;

public class Search2DMatrix {

    // O(log(m * n) time | O(1) space
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int r = mid / cols;
            int c = mid % cols;
            if (target == matrix[r][c]) {
                return true;
            } else if (target < matrix[r][c]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // O(log(m) + log(n)) time | O(1) space
    public boolean searchMatrix2(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int row = 0;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][cols]) {
                if (matrix[mid][0] == target || matrix[mid][cols] == target) {
                    return true;
                }
                row = mid;
                break;
            } else if (target < matrix[mid][cols]) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        int[] targetRow = matrix[row];
        int l = 0;
        int r = targetRow.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == targetRow[m]) {
                return true;
            } else if (target < targetRow[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }

}
