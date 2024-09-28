package august_2024;

import java.util.*;

public class WallsAndGates {

    static int WALLS = -1;
    static int GATES = 0;
    static int PATH = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {PATH, WALLS, GATES, PATH},
                {PATH, PATH, PATH, WALLS},
                {PATH, WALLS, PATH, WALLS},
                {GATES, WALLS, PATH, PATH}
        };
        List<int[]> coords = new ArrayList<>();
        coords.add(new int[] {3, 0});
        coords.add(new int[] {0, 2});

        int[][] result = wallsAndGates(matrix, coords);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int[][] wallsAndGates(int[][] matrix, List<int[]> coords) {
        if (matrix.length == 0) {
            return matrix;
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(); // todo: visited for gate_1 and gate_2 should be different

        for (int i = 0; i < coords.size(); i++) {
            queue.add(new int[] {coords.get(i)[0], coords.get(i)[1], 0});
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currRow = current[0]; // 3
                int currCol = current[1]; // 0
                int valueAtPos = current[2]; // 0
                matrix[currRow][currCol] = valueAtPos;

                List<int[]> neighbors = findNeighbors(matrix, current, valueAtPos, visited, "gate" + i);
                for (int[] neighbor : neighbors) {
                    queue.add(neighbor);
                }
            }
        }

        return matrix;
    }

    private static List<int[]> findNeighbors(int[][] matrix, int[] current, int valueAtPos, Set<String> visited, String gate) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        List<int[]> neighbors = new ArrayList<>();

        for (int[] direction : directions) {
            int newRow = current[0] + direction[0];
            int newCol = current[1] + direction[1];
            String key = generateKey(newRow, newCol, gate);
            if (!visited.contains(key) && isValidPos(matrix, newRow, newCol)
                    && matrix[newRow][newCol] != WALLS && matrix[newRow][newCol] != GATES
                    && valueAtPos + 1 < matrix[newRow][newCol]) {
                neighbors.add(new int[] {newRow, newCol, valueAtPos + 1});
            }
        }
        return neighbors;
    }

    private static String generateKey(int row, int col, String gate) {
        return row + ":" + col + ":" + gate;
    }

    private static boolean isValidPos(int[][] matrix, int row, int col) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }



}
