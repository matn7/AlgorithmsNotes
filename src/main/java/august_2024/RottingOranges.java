package august_2024;

import java.util.*;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 1, 1, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1}
        };

        int result = rottenOranges(matrix, new int[]{2, 1});
        System.out.println(result);
    }

    static int FRESH = 1;
    static int ROTTEN = 2;

    // O(n) time | O(n) space
    public static int rottenOranges(int[][] matrix, int[] coord) {

        if (matrix.length == 0) {
            return 0;
        }

//        {1, 0, 1, 0, 0},
//        {1, 1, 0, 0, 1},
//        {0, 2, 1, 1, 1},
//        {0, 1, 0, 0, 1}
        Queue<int[]> queue = new LinkedList<>();
        queue.add(coord);

        Set<String> visited = new HashSet<>();
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll(); // [2, 1]
                matrix[curr[0]][curr[1]] = ROTTEN;
                String key = curr[0] + ":" + curr[1];
                visited.add(key);
                List<int[]> neighbors = findNeighbors(matrix, curr, visited);
                queue.addAll(neighbors);
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

        return count;
    }

    private static List<int[]> findNeighbors(int[][] matrix, int[] coord, Set<String> visited) {
        List<int[]> coordinates = new ArrayList<>();

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = coord[0] + direction[0];
            int newCol = coord[1] + direction[1];
            String key = newRow + ":" + newCol;
            if (!visited.contains(key) && isValidPos(newRow, newCol, matrix) && matrix[newRow][newCol] == FRESH) {
                coordinates.add(new int[] {newRow, newCol});
            }
        }
        return coordinates;
    }

    private static boolean isValidPos(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }

}
















