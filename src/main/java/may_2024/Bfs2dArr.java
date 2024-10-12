package may_2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs2dArr {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        List<Integer> result = bfs2dArr(nums);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> bfs2dArr(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        boolean[][] visited = new boolean[nums.length][nums[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {2, 2});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            visited[row][col] = true;
            result.add(nums[row][col]);

            for (int[] direction : directions) {
                if (isValidPos(row + direction[0], col + direction[1], nums)
                        && !visited[row + direction[0]][col + direction[1]]) {
                    visited[row + direction[0]][col + direction[1]] = true;
                    queue.add(new int[] {row + direction[0], col + direction[1]});
                }
            }

        }

        return result;
    }

    private static boolean isValidPos(int row, int col, int[][] nums) {
        return row >= 0 && row <= nums.length - 1 && col >= 0 && col <= nums[row].length - 1;
    }

}
