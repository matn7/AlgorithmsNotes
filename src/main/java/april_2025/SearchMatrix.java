package april_2025;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 10;
        SearchMatrix searchMatrix = new SearchMatrix();
        boolean result = searchMatrix.searchMatrix(matrix, target);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length - 1;

        int t = 0;
        int b = matrix.length - 1;
        int m = 0;
        while (t <= b) {
            m = (t + b) / 2;
            if (matrix[m][cols] == target) {
                return true;
            }
            if (matrix[m][0] == target) {
                return true;
            }
            if (target > matrix[m][0] && target < matrix[m][cols]) {
                break;
            }
            if (matrix[m][cols] > target) {
                b = m - 1;
            } else {
                t = m + 1;
            }
        }

        int[] searchMatrix = matrix[m];
        int l = 0;
        int r = searchMatrix.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2; // (l + (r - l)/2)
            if (searchMatrix[mid] == target) {
                return true;
            } else if (searchMatrix[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

}
