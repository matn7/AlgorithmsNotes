package november_2025;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        Search2DMatrix search2DMatrix = new Search2DMatrix();
        boolean result = search2DMatrix.searchMatrix(matrix, target);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n * m - 1;

        while (left <= right) {
            int i = (left + right) / 2;
            int r = i / n;
            int c = i % n;
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return false;
    }

    // O(log(n) + log(m)) time | O(1) space
    public boolean searchMatrix2(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int cols = matrix[0].length - 1;

        int mid = -1;
        while (top <= bottom) {
            mid = (top + bottom) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][cols]) {
                if (matrix[mid][0] == target || matrix[mid][cols] == target) {
                    return true;
                }
                break;
            } else if (target < matrix[mid][cols]) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }

        }
        if (mid == -1) {
            return false;
        }
        int[] searchSpace = matrix[mid];
        int l = 0;
        int r = searchSpace.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == searchSpace[m]) {
                return true;
            } else if (target > searchSpace[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

}
