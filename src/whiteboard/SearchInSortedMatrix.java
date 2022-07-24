package whiteboard;

public class SearchInSortedMatrix {

    // O(n + m) time | O(1) space
    // #2: 30/06/2022
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        int row = 0;
        int col = matrix[row].length - 1;

        while (row < matrix.length && col >= 0) {
            int curr = matrix[row][col];
            if (curr > target) {
                col--;
            } else if (curr < target) {
                row++;
            } else {
                return new int[] {row, col};
            }
        }
        return new int[] {-1, -1};
    }

}
