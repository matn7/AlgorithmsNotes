package august_2024;

import java.util.*;

public class RottingOrangesV2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 1, 1, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1}
        };
        List<int[]> coords = new ArrayList<>();
        coords.add(new int[] {2, 1});
        coords.add(new int[] {3, 4});
        int result = rottingOranges(matrix, coords);
        System.out.println(result);
    }

    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    // O(n) time | O(n) space
    public static int rottingOranges(int[][] matrix, List<int[]> coords) {
//        if (matrix[coord[0]][coord[1]] == EMPTY) {
//            return 0;
//        }

        Queue<int[]> queue = new LinkedList<>();
        queue.addAll(coords);
        Set<String> seen = new HashSet<>();

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currRow = current[0];
                int currCol = current[1];
                String key = getKey(currRow, currCol);
                if (seen.contains(key)) {
                    continue;
                }
                seen.add(key);
                matrix[currRow][currCol] = ROTTEN;
                for (int[] direction : directions) {
                    int newRow = currRow + direction[0];
                    int newCol = currCol + direction[1];
                    String newKey = getKey(newRow, newCol);
                    if (isValidPos(newRow, newCol, matrix)
                            && isFreshOrange(newRow, newCol, matrix)
                            && !seen.contains(newKey)) {
                        queue.add(new int[] {newRow, newCol});
                    }
                }
            }
            count++;
        }
        return count;
    }

    private static boolean isFreshOrange(int row, int col, int[][] matrix) {
        return matrix[row][col] != ROTTEN && matrix[row][col] != EMPTY;
    }

    private static boolean isValidPos(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[row].length - 1;
    }

    private static String getKey(int row, int col) {
        return row + ":" + col;
    }

}
