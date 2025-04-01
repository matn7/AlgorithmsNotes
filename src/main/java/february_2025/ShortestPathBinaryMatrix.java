package february_2025;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };

        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
        int result = shortestPathBinaryMatrix.shortestPathBinaryMatrix(grid);
        System.out.println(result);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
//        boolean[][] seen = new boolean[grid.length][grid[0].length];
        grid[0][0] = -1;
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                if (r == grid.length - 1 && c == grid[r].length - 1) {
                    return length;
                }
                for (int[] dir : directions) {
                    int nR = r + dir[0];
                    int nC = c + dir[1];
                    if (nR < 0 || nR == grid.length || nC < 0 || nC == grid[nR].length || grid[nR][nC] == 1 || grid[nR][nC] == -1) {
                        continue;
                    }
                    grid[nR][nC] = -1;
                    queue.add(new int[] {nR, nC});
                }
            }
            length++;
        }

        return -1;
    }

}
