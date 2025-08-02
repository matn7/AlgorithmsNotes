package august_2025;

public class SearchMatrix {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 3, 5, 7},               // TOP
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}            // BOTTOM
//        };
//        int target = 3;

//        int[][] matrix = {{1}, {3}};
//        int target = 0;

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 10;

        SearchMatrix searchMatrix = new SearchMatrix();
        boolean result = searchMatrix.searchMatrix(matrix, target);
        System.out.println(result);

    }

    // O(log(n)) time | O(1) space
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int row = 0;
        int cols = matrix[0].length - 1;

        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            int[] currRow = matrix[mid];
            if (target >= currRow[0] && target <= currRow[cols]) {
                if (target == currRow[0] || target == currRow[cols]) {
                    return true;
                }
                row = mid;
                break;
            } else if (target < currRow[cols]) { // 3 < 20
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        int l = 0;
        int r = matrix[row].length - 1;
        int[] currRow = matrix[row];

        while (l <= r) {
            int m = (l + r) / 2;
            if (target == currRow[m]) {
                return true;
            } else if (target > currRow[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

}
