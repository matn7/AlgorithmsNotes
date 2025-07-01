package june_2025;

public class SurroundedRegions2 {

    public static void main(String[] args) {
        char[][] board = {
            {'X', 'O', 'X', 'O', 'X', 'O'},
            {'O', 'X', 'O', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'O', 'X', 'O'},
            {'O', 'X', 'O', 'X', 'O', 'X'},
        };

        SurroundedRegions2 surroundedRegions2 = new SurroundedRegions2();
        surroundedRegions2.solve(board);
        System.out.println();
    }

    public void solve(char[][] board) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (isOnBorder(board, r, c) && board[r][c] == 'O') {
                    mark(board, r, c);
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

    private void mark(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] == 'X' || board[r][c] == 'Y') {
            return;
        }
        board[r][c] = 'Y';
        mark(board, r + 1, c);
        mark(board, r - 1, c);
        mark(board, r, c + 1);
        mark(board, r, c - 1);
    }

    private boolean isOnBorder(char[][] board, int r, int c) {
        return r == 0 || c == 0 || r == board.length - 1 || c == board[r].length - 1;
    }

}
