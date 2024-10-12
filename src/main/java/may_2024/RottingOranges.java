package may_2024;

import javax.swing.*;
import java.util.*;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1}
        };

        List<int[]> coord = new ArrayList<>();
        coord.add(new int[] {0, 0});
        coord.add(new int[] {1, 4});
        int result = rottingOranges(matrix, coord);
        System.out.println(result);
    }

    static int ROTTEN = 2;
    static int FRESH = 1;
    static int EMPTY = 0;

    // O(n) time | O(n) space
    public static int rottingOranges(int[][] matrix, List<int[]> coords) {
        if (matrix.length == 0) {
            return 0;
        }

        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int[] coord : coords) {
            queue.add(coord);
            visited.add(coord[0] + "-" + coord[1]);
            matrix[coord[0]][coord[1]] = ROTTEN;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                matrix[rotten[0]][rotten[1]] = ROTTEN;
                findNeighbors(matrix, rotten, visited, queue);
            }
            count++;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == FRESH) {
                    return -1;
                }
            }
        }
        
        return count - 1;
    }

    private static void findNeighbors(int[][] matrix, int[] coord, Set<String> visited, Queue<int[]> queue) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = coord[0] + direction[0];
            int newCol = coord[1] + direction[1];
            String key = newRow + "-" + newCol;
            if (isValidPos(newRow, newCol, matrix) && !visited.contains(key) && matrix[newRow][newCol] == FRESH) {
                visited.add(key);
                queue.add(new int[] {newRow, newCol});
            }
        }
    }

    private static boolean isValidPos(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }

}
