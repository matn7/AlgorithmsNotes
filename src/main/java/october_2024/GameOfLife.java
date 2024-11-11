package october_2024;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(board);

        System.out.println();
    }

    public void gameOfLife(int[][] board) {

        int[][] nextState = new int[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                explore(r, c, board, nextState);
            }
        }
        for (int r = 0; r < board.length; r++) {
            System.arraycopy(nextState[r], 0, board[r], 0, board[r].length);
        }
    }

    private void explore(int r, int c, int[][] board, int[][] nextState) {
        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int count = 0;
        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (isValidPos(newR, newC, board) && board[newR][newC] == 1) {
                count++;
            }
        }
        if (count < 2 && board[r][c] == 1) {
            nextState[r][c] = 0;
        } else if ((count == 2 || count == 3) && board[r][c] == 1) {
            nextState[r][c] = 1;
        } else if (count > 4 && board[r][c] == 1) {
            nextState[r][c] = 0;
        } else if (count == 3 && board[r][c] == 0) {
            nextState[r][c] = 1;
        }
    }

    private boolean isValidPos(int r, int c, int[][] board) {
        return r >= 0 && r <= board.length - 1 && c >= 0 && c <= board[r].length - 1;
    }

}
