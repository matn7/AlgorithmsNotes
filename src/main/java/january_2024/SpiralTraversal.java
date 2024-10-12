package january_2024;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

    int[][] nums;
    public static void main(String[] args) {
        int[][] nums = {
                {1,   2,  3,  4,  5},
                {6,   7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        List<Integer> integers = new SpiralTraversal(nums).spiralTraversal();
        System.out.println(integers);
    }

    public SpiralTraversal(int[][] nums) {
        this.nums = nums;
    }

    // O(n) time | O(n) space
    public List<Integer> spiralTraversal() {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = nums.length - 1;
        int startCol = 0;
        int endCol = nums[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                int num = nums[startRow][col];
                result.add(num);
            }

            for (int row = startRow + 1; row <= endRow; row++) {
                int num = nums[row][endCol];
                result.add(num);
            }

            for (int col = endCol - 1; col >= startCol; col--) {
                if (endRow == startRow) {
                    break;
                }
                int num = nums[endRow][col];
                result.add(num);
            }

            for (int row = endRow - 1; row > startRow; row--) {
                if (endCol == startCol) {
                    break;
                }
                int num = nums[row][startCol];
                result.add(num);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }

}
