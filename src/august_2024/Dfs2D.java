package august_2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dfs2D {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        List<Integer> result = dfs2d(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> dfs2d(int[][] nums) {

        Set<String> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        dfs(nums, new int[] {2, 2}, visited, result);
        return result;
    }

    private static void dfs(int[][] nums, int[] coord, Set<String> visited, List<Integer> result) {
        String key = getKey(coord[0], coord[1]);
        if (visited.contains(key)) {
            return;
        }
        result.add(nums[coord[0]][coord[1]]);
        visited.add(key);

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = coord[0] + direction[0];
            int newCol = coord[1] + direction[1];
            if (isValidPos(newRow, newCol, nums)) {
                String newKey = getKey(newRow, newCol);
                if (!visited.contains(newKey)) {
                    dfs(nums, new int[] {newRow, newCol}, visited, result);
                }
            }
        }
    }

    private static String getKey(int row, int col) {
        return row + ":" + col;
    }

    private static boolean isValidPos(int row, int col, int[][] nums) {
        return row >= 0 && row <= nums.length - 1 && col >= 0 && col <= nums[row].length - 1;
    }

}
