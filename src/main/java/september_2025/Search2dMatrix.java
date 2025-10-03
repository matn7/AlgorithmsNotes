package september_2025;

public class Search2dMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        Search2dMatrix search2dMatrix = new Search2dMatrix();
        boolean result = search2dMatrix.searchMatrix(matrix, target);
        System.out.println(result);
    }

    // O(log(m) + log(n)) time | O(1) space
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int row = 0;
        int cols = matrix[0].length - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            int[] midRow = matrix[mid];
            if (target >= midRow[0] && target <= midRow[cols]) {
                if (target == midRow[0] || target == midRow[cols]) {
                    return true;
                }
                row = mid;
                break;
            } else if (target < midRow[cols]) {
                bottom--;
            } else {
                top++;
            }
        }

        int[] searchRow = matrix[row];
        int l = 0;
        int r = searchRow.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == searchRow[m]) {
                return true;
            } else if (target > searchRow[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

}
