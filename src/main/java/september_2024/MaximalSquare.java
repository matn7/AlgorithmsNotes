package september_2024;

public class MaximalSquare {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '1', '1', '1'}
        };

        MaximalSquare maximalSquare = new MaximalSquare();
        int result = maximalSquare.maximalSquare(matrix);
        System.out.println(result);

    }

    // O(n*m) time | O(n*m) space
    public int maximalSquare(char[][] matrix) {
        int[][] intMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                intMatrix[i][j] = matrix[i][j] - '0';
            }
        }

        int[][] cache = new int[intMatrix.length][intMatrix[0].length];
        int max = 0;
        for (int i = 0; i < intMatrix.length; i++) {
            cache[i][0] = intMatrix[i][0];
            max = Math.max(max, cache[i][0]);
        }
        for (int i = 0; i < intMatrix[0].length; i++) {
            cache[0][i] = intMatrix[0][i];
            max = Math.max(max, cache[0][i]);
        }

        for (int row = 1; row < intMatrix.length; row++) {
            for (int col = 1; col < intMatrix[row].length; col++) {
                int left = cache[row][col - 1];
                int up = cache[row - 1][col];
                int diagonal = cache[row - 1][col - 1];
                if (left > 0 && up > 0 && diagonal > 0 && intMatrix[row][col] == 1) {
                    if (left == diagonal && up == diagonal) {
                        cache[row][col] = diagonal + 1;
                    } else {
                        cache[row][col] = Math.min(left, Math.min(diagonal, up)) + 1;
                    }
                } else {
                    cache[row][col] = intMatrix[row][col];
                }
                max = Math.max(max, cache[row][col]);
            }
        }
        return max * max;
    }

}
