package medium;

public class SearchInSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,    4,    7,  12,  15, 1000},
                {2,    5,   19,  31,  32, 1001},
                {3,    8,   24,  33,  35, 1002},
                {40,  41,   42,  44,  45, 1003},
                {99, 100,  103, 106, 128, 1004}};

        searchInSortedMatrix(matrix, 44);
    }

//    [1,    4,    7,  12,  15, 1000],
//    [2,    5,   19,  31,  32, 1001],
//    [3,    8,   24,  33,  35, 1002],
//    [40,  41,   42,  44*,  45, 1003],
//    [99, 100,  103, 106, 128, 1004]

    // O(n + m) time | O(1) space
    // OK - repeated 09/02/2022
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int row = 0;
        int col = matrix[row].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) { // 45 > 44
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return new int[] {row, col};
            }
        }
        return new int[] {-1, -1};
    }
}
