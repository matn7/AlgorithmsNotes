package october_2025;

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

    // O(log(m) + log(n)) time | O(1) space
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int row = 0;
        while (top <= bottom) {
            row = (top + bottom) / 2;
            if (target >= matrix[row][0] && target <= matrix[row][cols]) {
                if (target == matrix[row][0] || target == matrix[row][cols]) {
                    return true;
                }
                break;
            } else if (target > matrix[row][cols]) {
                top = row + 1;
            } else {
                bottom = row - 1;
            }
        }
        int[] targetRow = matrix[row];
        int l = 0;
        int r = targetRow.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == targetRow[m]) {
                return true;
            } else if (target > targetRow[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

}
