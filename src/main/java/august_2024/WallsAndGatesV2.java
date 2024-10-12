package august_2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WallsAndGatesV2 {


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

        wallsAndGates(matrix, coords);
    }

    static int WALLS = -1;
    static int GATES = 0;
    static int PATH = Integer.MAX_VALUE;

    // O(n) time | O(n) space
    public static int[][] wallsAndGates(int[][] matrix, List<int[]> coords) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < coords.size(); i++) {
            int[] coord = coords.get(i);
            dfs(matrix, coord, seen, i);
        }
        return matrix;
    }

    private static void dfs(int[][] matrix, int[] coords, Set<String> seen, int gateId) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = coords[0] + direction[0];
            int newCol = coords[1] + direction[1];
            if (isValidPos(newRow, newCol, matrix)) {
                String key = getKey(newRow, newCol, gateId);
                if (!seen.contains(key) && matrix[newRow][newCol] != WALLS) {
                    int coordValue = matrix[coords[0]][coords[1]];
                    matrix[newRow][newCol] = Math.min(matrix[newRow][newCol], coordValue + 1);
                    seen.add(key);
                    dfs(matrix, new int[] {newRow, newCol}, seen, gateId);
                }
            }
        }
    }

    private static boolean isValidPos(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }

    private static String getKey(int row, int col, int gateId) {
        return row + ":" + col + ":" + gateId;
    }

}
























