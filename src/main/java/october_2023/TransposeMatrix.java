package october_2023;

public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] transpose = transposed(matrix);
        System.out.println();
    }

    // O(n*m) time | O(n*m) space
    public static int[][] transposed(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                transposed[col][row] = matrix[row][col];
            }
        }

        return transposed;
    }

}
