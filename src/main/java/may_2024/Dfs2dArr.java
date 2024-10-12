package may_2024;

import java.util.ArrayList;
import java.util.List;

public class Dfs2dArr {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        List<Integer> result = dfs2dArr(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> dfs2dArr(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[nums.length][nums[0].length];
        dfs(2, 2, nums, visited, result);
        return result;
    }

    private static void dfs(int row, int col, int[][] nums, boolean[][] visited, List<Integer> result) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        //                 [row -1, col]
        // [row, col - 1]  [row, col]       [row, col + 1]
        //                 [row + 1, col
        result.add(nums[row][col]);
        visited[row][col] = true;
        for (int[] direction : directions) {
            if (isValidPos(row + direction[0], col + direction[1], nums)
                && !visited[row + direction[0]][col + direction[1]]) {
                dfs(row + direction[0], col + direction[1], nums, visited, result);
            }
        }
    }

    private static boolean isValidPos(int row, int col, int[][] nums) {
        return row >= 0 && row <= nums.length - 1 && col >= 0 && col <= nums[0].length - 1;
    }

}
