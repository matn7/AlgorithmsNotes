package june_2025;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 34;

        SearchMatrix searchMatrix = new SearchMatrix();
        boolean result = searchMatrix.searchMatrix(matrix, target);
        System.out.println(result);
    }

    // O(log(n)) time | O(n) space
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int row = 0;
        while (top <= bottom) {
            row = (top + bottom) / 2;
            int l = matrix[row][0];
            int r = matrix[row][cols];
            if (target >= l && target <= r) {
                break;
            } else if (target < r) {
                bottom = row - 1;
            } else {
                top = row + 1;
            }
        }
        int l = 0;
        int r = matrix[row].length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == matrix[row][m]) {
                return true;
            } else if (target > matrix[row][m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

}
