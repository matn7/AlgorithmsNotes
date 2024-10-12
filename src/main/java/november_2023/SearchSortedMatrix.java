package november_2023;

public class SearchSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 8},
                {10, 11, 15, 16},
                {24, 27, 30, 31}
        };

        int value = 10;

        boolean result = searchSortedMatrix(matrix, value);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static boolean searchSortedMatrix(int[][] matrix, int value) {
        int row = 0;
        int col = matrix[row].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == value) {
                return true;
            } else if (matrix[row][col] < value) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

}
