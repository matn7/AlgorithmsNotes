package november_2023;

public class SearchSortedMatrixV2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 8},
                {10, 11, 15, 16},
                {24, 27, 30, 31}
        };

        System.out.println(searchSortedMatrix(matrix, 2));
    }

    // O(log(n)) time | O(1) space
    public static boolean searchSortedMatrix(int[][] matrix, int value) {
        if (matrix.length == 0) {
            return false;
        }
        int rows = matrix.length - 1;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols;
        while (low < high) {
            int mid = (low + high) / 2;
            int mid_val = matrix[mid / cols][mid % cols];
            if (mid_val == value) {
                return true;
            }
            if (mid_val < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return false;
    }

}
