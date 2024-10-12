package udemy.generalprogramming;

public class GameOfLife {

    private static final int N = 9;

    public static int[][] getNextGeneration(int[][] current) {
        int[][] next = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                next[i][j] = getCellState(i, j, current);
            }
        }
        return next;
    }

    public static int getCellState(int row, int col, int[][] current) {
        int liveCount = 0;
        // assuming a N x N matrix representing one generation, the last cell index will be N - 1
        int lastCellIndex = N - 1;

        // check the number of live neighbors a cell has, neighbors ar 4 sides and corners
        if (row > 0 && col > 0) {
            liveCount += current[row - 1][col - 1];
        }
        if (row > 0) {
            liveCount += current[row - 1][col];
            if (col < lastCellIndex) {
                liveCount += current[row - 1][col + 1];
            }
        }
        if (col < lastCellIndex) {
            liveCount += current[row][col + 1];
        }
        if (col > 0) {
            liveCount += current[row][col - 1];
            if (row < lastCellIndex) {
                liveCount += current[row + 1][col - 1];
            }
        }
        if (row < lastCellIndex) {
            liveCount += current[row + 1][col];
        }
        if (row < lastCellIndex && col < lastCellIndex) {
            liveCount += current[row + 1][col + 1];
        }

        return liveCount == 2 ? 1 : 0;
    }

}
