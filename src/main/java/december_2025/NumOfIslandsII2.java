package december_2025;

import java.util.ArrayList;
import java.util.List;

public class NumOfIslandsII2 {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};

        NumOfIslandsII2 numOfIslandsII2 = new NumOfIslandsII2();
        List<Integer> result = numOfIslandsII2.numIslands2(m, n, positions);
        System.out.println(result);
    }

    int[][] matrix;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        matrix = new int[m][n];
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int[] pos : positions) {
            int count = 0;
            matrix[pos[0]][pos[1]] = 1;
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (matrix[r][c] == 1 && !visited[r][c]) {
                        count++;
                        dfs(r, c, visited);
                    }
                }
            }
            visited = new boolean[m][n];
            result.add(count);
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || matrix[r][c] == 0 || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], visited);
        }
    }

}
