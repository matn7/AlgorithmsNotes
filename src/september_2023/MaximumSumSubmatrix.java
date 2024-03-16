package september_2023;

public class MaximumSumSubmatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 3, -1, 5},
                {-7, 3, 7, 4},
                {12, 8, 0, 0},
                {1, -8, -8, 2}
        };

        MaximumSumSubmatrix maximumSumSubmatrix = new MaximumSumSubmatrix();
        maximumSumSubmatrix.maximumSumSubmatrix2(matrix, 2);
    }

    // O(w*h*s^2) time | O(1) space
    public int maximumSumSubmatrix(int[][] matrix, int size) {
        // Write your code here.
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= matrix.length - size; i++) {
            for (int j = 0; j <= matrix[i].length - size; j++) {
                int currSum = 0;
                for (int row = i; row < i + size; row++) {
                    for (int col = j; col < j + size; col++) {
                        currSum += matrix[row][col];
                    }
                }
                System.out.println("currSum " + currSum);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    // O(w*h) time | O(w*h) space
    public int maximumSumSubmatrix2(int[][] matrix, int size) {
        int[][] sums = createSumMatrix(matrix);
        int maxSubMatrixSum = Integer.MIN_VALUE;

        for (int row = size - 1; row < matrix.length; row++) {
            for (int col = size - 1; col < matrix[row].length; col++) {
                int total = sums[row][col];

                boolean touchesTopBorder = row - size < 0;
                if (!touchesTopBorder) {
                    total -= sums[row - size][col];
                }

                boolean touchesLeftBorder = col - size < 0;
                if (!touchesLeftBorder) {
                    total -= sums[row][col - size];
                }

                boolean touchesTopOrLeftBorder = touchesTopBorder || touchesLeftBorder;
                if (!touchesTopOrLeftBorder) {
                    total += sums[row - size][col - size];
                }

                maxSubMatrixSum = Math.max(maxSubMatrixSum, total);
            }
        }

        return maxSubMatrixSum;
    }

    private int[][] createSumMatrix(int[][] matrix) {
        int[][] sums = new int[matrix.length][matrix[0].length];
        sums[0][0] = matrix[0][0];

        for (int idx = 1; idx < matrix[0].length; idx++) {
            sums[0][idx] = sums[0][idx - 1] + matrix[0][idx];
        }

        for (int idx = 1; idx < matrix.length; idx++) {
            sums[idx][0] = sums[idx - 1][0] + matrix[idx][0];
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                sums[row][col] = sums[row - 1][col] + sums[row][col - 1] - sums[row - 1][col - 1] + matrix[row][col];
            }
        }

        return sums;
    }


}
