package january_2026;

import udemy.recursion.BuildACarMy;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;

        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        boolean result = searchA2DMatrix.searchMatrix(matrix, target);
        System.out.println(result);
    }

    // O(log(n * m)) time | O(1) space
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0;
        int r = rows * cols - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int row = mid / cols;
            int col = mid % cols;

            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    // O(log(n) + log(m)) time | O(1) space
    public boolean searchMatrix2(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int row = 0;
        while (top <= bottom) {
            row = (top + bottom) / 2;
            if (target >= matrix[row][0] && target <= matrix[row][cols]) {
                // found row
                if (target == matrix[row][0] || target == matrix[row][cols]) {
                    return true;
                }
                break;
            }
            if (target < matrix[row][cols]) {
                bottom = row - 1;
            } else {
                top = row + 1;
            }
        }

        int[] array = matrix[row];
        int l = 0;
        int r = array.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == array[mid]) {
                return true;
            }
            if (target < array[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

}
