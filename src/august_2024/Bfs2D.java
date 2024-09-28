package august_2024;

import java.util.*;

public class Bfs2D {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        List<Integer> result = bfs2d(nums);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static List<Integer> bfs2d(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        bfs(nums, new int[] {2, 2}, result, seen);
        return result;
    }

    private static void bfs(int[][] nums, int[] coord, List<Integer> result, Set<String> seen) {

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(coord);

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            String key = getKey(row, col);
            if (!seen.contains(key)) {
                seen.add(key);
                result.add(nums[row][col]);
            }
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (isValidPos(newRow, newCol, nums)) {
                    String newKey = getKey(newRow, newCol);
                    if (!seen.contains(newKey)) {
                        queue.add(new int[] {newRow, newCol});
                    }
                }
            }
        }
    }

    private static boolean isValidPos(int row, int col, int[][] nums) {
        return row >= 0 && row <= nums.length - 1 && col >= 0 && col <= nums[row].length - 1;
    }

    private static String getKey(int row, int col) {
        return row + ":" + col;
    }

}
