package coderpro;

public class MazePaths {

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0},
                {0, 0, 1},
                {0, 0, 0}
        };

        MazePaths mazePaths = new MazePaths();
        mazePaths.path_through_maze(maze);
    }

    // O(n) time | O(n) space
    public int path_through_maze(int[][] maze) {
        int[][] paths = new int[maze.length][maze[0].length];
        paths[0][0] = 1;

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                int val = maze[row][col];
                if (val == 1 || (row == 0 && col == 0)) {
                    continue;
                }
                int topPaths = 0;
                int leftPaths = 0;
                if (row > 0) {
                    leftPaths = paths[row - 1][col];
                }
                if (col > 0) {
                     topPaths = paths[row][col - 1];
                }
                paths[row][col] = leftPaths + topPaths;
            }
        }
        int result = paths[paths.length - 1][paths[0].length - 1];
        return result;
    }

}