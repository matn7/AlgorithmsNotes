package october_2024;

public class GameOfLife2 {

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        GameOfLife2 gameOfLife = new GameOfLife2();
        gameOfLife.gameOfLife(board);

        System.out.println();
    }

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int nei = countNeighbors(r, c, board);

                if (board[r][c] == 1) {
                    if (nei == 2 || nei == 3) {
                        board[r][c] = 3;
                    }
                } else if (nei == 3) {
                    board[r][c] = 2;
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 1) {
                    board[r][c] = 0;
                } else if (board[r][c] == 2 || board[r][c] == 3) {
                    board[r][c] = 1;
                }
            }
        }
    }

    private int countNeighbors(int r, int c, int[][] board) {
        int nei = 0;
        for (int i = r - 1; i < r + 2; i++) {
            for (int j = c - 1; j < c + 2; c++) {
                if ((i == r && j == c) || i < 0 || j < 0 || i == board.length || j == board[0].length) {
                    continue;
                }
                if (board[i][j] == 1 || board[i][j] == 3) {
                    nei++;
                }
            }
        }
        return nei;
    }

    private int countNeighbors2(int r, int c, int[][] board) {
        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        int count = 0;
        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (isValidPos(newR, newC, board) && board[newR][newC] == 1) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidPos(int r, int c, int[][] board) {
        return r >= 0 && r <= board.length - 1 && c >= 0 && c <= board[r].length - 1;
    }

}
