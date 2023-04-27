package star;

public class SearchingAMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  3,  5,  8},
                {10, 11, 15, 16},
                {24, 27, 30, 31}
        };

        SearchingAMatrix searchingAMatrix = new SearchingAMatrix();
        searchingAMatrix.searchMatrix(matrix, 24);
    }

    // O(log(n)) time | O(1) space
    public boolean searchMatrix(int[][] matrix, int value) {
        int cols = matrix[0].length; // 4
        int rows = matrix.length; // 3

        int low = 0; // 0
        int high = rows * cols; // 12

        // l                                           h
        // 1,  3,  5,  8, 10, 11, 15, 16, 24, 27, 30, 31
        // 0   1   2   3   4   5   6   7   8   9  10  11
        while (low < high) {
            int mid = (low + high) / 2; // 5
            int midVal = matrix[mid / cols][mid % cols];

            System.out.println(midVal);

            if (midVal == value) {
                return true;
            }

            if (midVal < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return false;
    }
}
