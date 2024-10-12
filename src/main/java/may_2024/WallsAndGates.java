package may_2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WallsAndGates {

    static int INF = Integer.MAX_VALUE;
    static int WALLS = -1;
    static int GATES =- 0;
    static String GATE_1 = "GATE_1";
    static String GATE_2 = "GATE_2";


    public static void main(String[] args) {
        int[][] matrix = {
                {INF, WALLS, GATES, INF},
                {INF, INF, INF, WALLS},
                {INF, WALLS, INF, WALLS},
                {GATES, WALLS, INF, INF}
        };

        List<int[]> gatesCoords = new ArrayList<>();
        gatesCoords.add(new int[] {0, 2});
        gatesCoords.add(new int[] {3, 0});

        int[][] result = wallsAndGates(matrix, gatesCoords);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int[][] wallsAndGates(int[][] matrix, List<int[]> gatesCoords) {
        Set<String> visited = new HashSet<>();
        String key1 = getKey(gatesCoords.get(0), GATE_1);
        String key2 = getKey(gatesCoords.get(1), GATE_2);
        visited.add(key1);
        visited.add(key2);
        dfs(gatesCoords.get(0)[0], gatesCoords.get(0)[1], matrix, visited, GATE_1);
        dfs(gatesCoords.get(1)[0], gatesCoords.get(1)[1], matrix, visited, GATE_2);
        return matrix;
    }

    private static void dfs(int row, int col, int[][] matrix, Set<String> visited, String gateId) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            String key = getKey(new int[] {newRow, newCol}, gateId);
            if (isValidPos(newRow, newCol, matrix) && !visited.contains(key)
                    && matrix[newRow][newCol] != GATES && matrix[newRow][newCol] != WALLS
                    && matrix[newRow][newRow] >= matrix[row][col] + 1) {
                matrix[newRow][newCol] = matrix[row][col] + 1;
                visited.add(key);
                dfs(newRow, newCol, matrix, visited, gateId);
            }
        }
    }

    private static boolean isValidPos(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }

    private static String getKey(int[] coord, String id) {
        return coord[0] + "-" + coord[1] + "-" + id;
    }
}
