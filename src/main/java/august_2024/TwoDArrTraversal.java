package august_2024;

import java.util.*;

public class TwoDArrTraversal {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
        };

        int[] start = {2, 2};
        List<Integer> bfs = bfs(nums, start);
        // [13, 8, 14, 18, 12, 3, 9, 7, 15, 19, 17, 11, 4, 2, 10, 6, 20, 16, 5, 1]
        // [13, 8, 14, 18, 12, 3, 9, 7, 15, 19, 17, 11, 4, 2, 10, 6, 20, 16, 5, 1]
        System.out.println(bfs);

        List<Integer> dfs = dfs(nums, start);
        // [13, 8, 3, 4, 5, 10, 15, 20, 19, 14, 9, 18, 17, 12, 7, 2, 1, 6, 11, 16]
        // [13, 8, 3, 4, 5, 10, 15, 20, 19, 14, 9, 18, 17, 12, 7, 2, 1, 6, 11, 16]
        System.out.println(dfs);
    }

    // O(n) time | O(n) space
    public static List<Integer> dfs(int[][] nums, int[] start) {
        List<Integer> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        dfsHelper(nums, start, result, seen);
        return result;
    }

    private static void dfsHelper(int[][] nums, int[] coord,
                                  List<Integer> result, Set<String> seen) {
        String key = getKey(coord[0], coord[1]);
        if (!seen.contains(key)) {
            result.add(nums[coord[0]][coord[1]]);
            seen.add(key);
        }
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] direction : directions) {
            int newX = coord[0] + direction[0];
            int newY = coord[1] + direction[1];
            String newKey = getKey(newX, newY);
            if (isValidPos(newX, newY, nums) && !seen.contains(newKey)) {
                dfsHelper(nums, new int[] {newX, newY}, result, seen);
            }
        }
    }

    // O(n) time | O(n) space
    public static List<Integer> bfs(int[][] nums, int[] start) {
        List<Integer> result = new ArrayList<>();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Set<String> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currX = current[0];
            int currY = current[1];
            String key = getKey(currX, currY);
            if (seen.contains(key)) {
                continue;
            }
            seen.add(key);
            result.add(nums[currX][currY]);

            for (int[] direction : directions) {
                int newX = currX + direction[0];
                int newY = currY + direction[1];
                if (isValidPos(newX, newY, nums)) {
                    String newKey = getKey(newX, newY);
                    if (!seen.contains(newKey)) {
                        queue.add(new int[] {newX, newY});
                    }
                }
            }
        }

        return result;
    }

    private static String getKey(int x, int y) {
        return x + ":" + y;
    }

    private static boolean isValidPos(int row, int col, int[][] nums) {
        return row >= 0 && row <= nums.length - 1 && col >= 0 && col <= nums[row].length - 1;
    }

}
