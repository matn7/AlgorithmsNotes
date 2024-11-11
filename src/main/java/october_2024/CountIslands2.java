package october_2024;

public class CountIslands2 {

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };

        int[][] grid2 = {
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        };

        CountIslands2 countIslands = new CountIslands2();
        countIslands.countSubIslands(grid1, grid2);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int r = 0; r < grid1.length; r++) {
            for (int c = 0; c < grid1[r].length; c++) {
                if (grid1[r][c] == 1 && grid2[r][c] == 1) {
                    grid2[r][c] = 2;
                }
            }
        }
        return count;
    }

}


























