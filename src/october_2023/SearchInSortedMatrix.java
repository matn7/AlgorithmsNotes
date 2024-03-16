package october_2023;

public class SearchInSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}
        };

        int target = 44;

        int[] result = searchMatrix(matrix, target);
        System.out.println(result);
    }

    // O(n + m) time | O(1) space
    public static int[] searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[row].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[] {row, col};
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return new int[] {-1, -1};
    }

}
