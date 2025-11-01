package october_2025;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println(result);
    }

    // O(n * m) time | O(1) space
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            for (int i = right - 1; i >= left; i--) {
                if (top == bottom) {
                    break;
                }
                result.add(matrix[bottom][i]);
            }

            for (int i = bottom - 1; i > top; i--) {
                if (left == right) {
                    break;
                }
                result.add(matrix[i][left]);
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return result;
    }


}
