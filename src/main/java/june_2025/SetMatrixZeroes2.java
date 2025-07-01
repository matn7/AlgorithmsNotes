package june_2025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SetMatrixZeroes2 {

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        SetMatrixZeroes2 setMatrixZeroes2 = new SetMatrixZeroes2();
        setMatrixZeroes2.setZeroes(matrix);

        System.out.println();
    }

    // O((n * m) * (n + m)) time | O(n * m) space
    public void setZeroes(int[][] matrix) {
        Queue<int[]> zeroCoord = new LinkedList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    zeroCoord.add(new int[] {r, c});
                }
            }
        }

        while (!zeroCoord.isEmpty()) {
            int[] current = zeroCoord.poll();
            int row = current[0];
            int col = current[1];

            for (int c = 0; c < matrix[row].length; c++) {
                matrix[row][c] = 0;
            }
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][col] = 0;
            }
        }
    }


}
