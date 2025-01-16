package december_2024;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> integers = spiralMatrix.spiralOrder(matrix);
        System.out.println(integers);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int L = 0;
        int R = matrix[0].length - 1;
        int T = 0;
        int B = matrix.length - 1;

        while (L <= R && T <= B) {

            for (int i = L; i <= R; i++) {
                result.add(matrix[T][i]);
            }
            for (int i = T + 1; i <= B; i++) {
                result.add(matrix[i][R]);
            }
            for (int i = R - 1; i >= L; i--) {
                if (T == B) {
                    break;
                }
                result.add(matrix[B][i]);
            }
            for (int i = B - 1; i > T; i--) {
                if (L == R) {
                    break;
                }
                result.add(matrix[i][L]);
            }

            L++;
            R--;
            T++;
            B--;
        }

        return result;
    }

}
