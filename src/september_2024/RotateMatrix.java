package september_2024;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotate(matrix);
        System.out.println();
    }

    // O(n) time | O(n) space
    public int[][] rotateMatrix(int[][] matrix) {

        int r = 0;

        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int col = 0; col < matrix[0].length; col++) {
            int c = 0;
            for (int row = matrix.length - 1; row >= 0; row--) {
                newMatrix[r][c] = matrix[row][col];
                c++;
            }
            r++;
        }

        return newMatrix;
    }

    // Book
    // O(n^2) time
    boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;

            }
        }
        return true;
    }

}
