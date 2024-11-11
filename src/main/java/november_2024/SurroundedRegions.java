package november_2024;

public class SurroundedRegions {

    public static void main(String[] args) {
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'},
//        };

        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };


        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);
    }

    public void solve(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (isOnBorder(r, c, board) && board[r][c] != 'Y' && board[r][c] == 'O') {
                    explore(board, r, c);
                }
            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'Y') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void explore(char[][] board, int r, int c) {
        board[r][c] = 'Y';
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newRow = r + direction[0];
            int newCol = c + direction[1];
            if (isValidPos(newRow, newCol, board) && board[newRow][newCol] == 'O') {
                explore(board, newRow, newCol);
            }
        }

    }

    private boolean isValidPos(int r, int c, char[][] board) {
        return r >= 0 && r <= board.length - 1 && c >= 0 && c <= board[r].length - 1;
    }

    private boolean isOnBorder(int row, int col, char[][] board) {
        return row == 0 || col == 0 || row == board.length - 1 || col == board[row].length - 1;
    }

}
