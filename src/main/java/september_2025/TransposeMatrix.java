package september_2025;

public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        TransposeMatrix transposeMatrix = new TransposeMatrix();
        int[][] transpose = transposeMatrix.transpose(matrix);
        System.out.println(transpose);
    }

    // O(n * m) time | O(n * m) space
    public int[][] transpose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                transposedMatrix[c][r] = matrix[r][c];
            }
        }
        return transposedMatrix;
    }


}
