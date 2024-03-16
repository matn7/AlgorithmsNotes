package coderpro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands2 {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 1, 1, 1, 1}
        };

        NumberOfIslands2 numberOfIslands2 = new NumberOfIslands2();
        numberOfIslands2.numberOfIslands(arr);
    }

    public int numberOfIslands(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int result = 0;

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (!visited[row][col] && arr[row][col] == 0) {
                    result++;
                    explore(arr, visited, row, col);
                }
            }
        }
        return result;
    }

    private void explore(int[][] arr, boolean[][] visited, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            if (visited[currX][currY]) {
                continue;
            }
            visited[currX][currY] = true;
            if (arr[currX][currY] == 1) {
                continue;
            }
            List<int[]> neighbors = getNeighbors(arr, visited, currX, currY);
            for (int[] neighbor : neighbors) {
                queue.add(neighbor);
            }
        }
    }

    private List<int[]> getNeighbors(int[][] arr, boolean[][] visited, int row, int col) {
        List<int[]> result = new ArrayList<>();
        if (row > 0 && !visited[row - 1][col]) {
            result.add(new int[] {row - 1, col});
        }
        if (col > 0 && !visited[row][col - 1]) {
            result.add(new int[] {row, col - 1});
        }
        if (row < arr.length - 1 && !visited[row + 1][col]) {
            result.add(new int[] {row + 1, col});
        }
        if (col < arr[row].length - 1 && !visited[row][col + 1]) {
            result.add(new int[] {row, col + 1});
        }
        return result;
    }
}
