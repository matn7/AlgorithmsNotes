package coderpro;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal2 {

    public static void main(String[] args) {
        int[][] arr = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15}
        };

//        {16, 17, 18, 19, 20},
//        {21, 22, 23, 24, 25},

        SpiralTraversal2 spiralTraversal2 = new SpiralTraversal2();
        spiralTraversal2.spiralTraversal(arr);
    }

    public List<Integer> spiralTraversal(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = arr.length - 1;
        int startCol = 0;
        int endCol = arr[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int i = startCol; i <= endCol; i++) {
                result.add(arr[startRow][i]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(arr[i][endCol]);
            }
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow) {
                    break;
                }
                result.add(arr[endRow][i]);
            }
            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol == endCol) {
                    break;
                }
                result.add(arr[i][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }


        return result;
    }

}
