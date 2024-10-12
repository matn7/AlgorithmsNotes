package november_2023;

public class MazePathsV2 {

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0},
                {0, 0, 1},
                {0, 0, 0}
        };

        int result = mazePaths(maze);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int mazePaths(int[][] maze) {
        int[][] paths = new int[maze.length][maze[0].length];
        paths[0][0] = 1;

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                int value = maze[row][col];
                if (value == 1 || (row == 0 && col == 0)) {
                    continue;
                }
                int topPaths = 0;
                int leftPaths = 0;
                if (row > 0) {
                    topPaths = paths[row - 1][col];
                }
                if (col > 0) {
                    leftPaths = paths[row][col - 1];
                }
                paths[row][col] = leftPaths + topPaths;
            }
        }

        return paths[maze.length - 1][maze[0].length - 1];
    }

}
